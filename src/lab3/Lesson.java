package lab3;

import lab2.Action;
import lab2.Day;

public class Lesson {

    Term term;
    String name;
    String teacherName;
    int year;
    boolean full_time;

    Lesson(Term term, String name, String teacherName, int year) {
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = true;
    }

    Lesson(Term term, String name, String teacherName, int year, boolean full_time) {
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }

    public Lesson clone() {
        return new Lesson(this.term, this.name, this.teacherName, this.year, this.full_time);
    }

    public boolean equals(Lesson lesson) {
        return (this.term.equals(lesson.term) &&
                this.name.equals(lesson.name) &&
                this.teacherName.equals(lesson.teacherName) &&
                this.year == lesson.year &&
                this.full_time == lesson.full_time);
    }

    public String toString() {
        return name + " (" + this.term + ")\n" + "rok: " + this.year + ", stacjonarne: " + this.full_time + "\nProwadzący: " + teacherName;
    }

    boolean earlierDay() {
        if (this.full_time) {
            if (this.term.day == Day.MON) return false;
        } else {
            if (this.term.day == Day.FRI) return false;
            if (this.term.day == Day.SAT && this.term.getStartInMinutes() - this.term.duration < 17*60) return false;
        }
        this.term.earlierDay();
        return true;
    }

    boolean laterDay() {
        if (this.full_time) {
            if (this.term.day == Day.FRI) return false;
            if (this.term.day == Day.THU && this.term.getEndInMinutes() + this.term.duration > 20*60) return false;
        } else {
            if (this.term.day == Day.SUN) return false;
        }
        this.term.laterDay();
        return true;
    }

    boolean earlierTime() {
        if (this.term.getStartInMinutes() - this.term.duration < 8*60) return false;
        if (!this.full_time && this.term.day == Day.FRI && this.term.getStartInMinutes() - this.term.duration < 17*60) return false;
        this.term = this.term.startTerm();
        return true;
    }

    boolean laterTime() {
        if (this.term.getEndInMinutes() + this.term.duration > 20*60) return false;
        if (this.full_time && this.term.day == Day.FRI && this.term.getStartInMinutes() + this.term.duration > 17*60) return false;
        this.term = this.term.endTerm();
        return true;
    }

    void applyActions(Action[] actions) {
        for (Action a : actions) {
            switch (a) {
                case DAY_LATER: {
                    this.laterDay();
                    break;
                }
                case TIME_LATER: {
                    this.laterTime();
                    break;
                }
                case DAY_EARLIER: {
                    this.earlierDay();
                    break;
                }
                case TIME_EARLIER: {
                    this.earlierTime();
                    break;
                }
            }
        }
    }

}

package lab3;

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

    public Lesson clone() {
        Lesson result = new Lesson(this.term, this.name, this.teacherName, this.year);
        result.full_time = this.full_time;
        return result;
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

}

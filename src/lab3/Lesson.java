package lab3;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab4.ITimetable;

public class Lesson {

    private ITimetable timetable;
    private Term term;
    private String name;
    private String teacherName;
    private int year;
    private boolean full_time;

    public Lesson(Term term, String name, String teacherName, int year) {
        this.setTerm(term);
        this.setName(name);
        this.setTeacherName(teacherName);
        this.setYear(year);
        this.setFull_time(true);
    }

    public Lesson(Term term, String name, String teacherName, int year, boolean full_time) {
        this.setTerm(term);
        this.setName(name);
        this.setTeacherName(teacherName);
        this.setYear(year);
        this.setFull_time(full_time);
    }

    public Lesson(ITimetable timetable, Term term, String name, String teacherName, int year) {
        this.timetable = timetable;
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
    }

    public Lesson(ITimetable timetable, Term term, String name, String teacherName, int year, boolean full_time) {
        this.timetable = timetable;
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = full_time;
    }

    public Lesson clone() {
        return new Lesson(this.timetable, this.getTerm(), this.getName(), this.getTeacherName(), this.getYear(), this.isFull_time());
    }

    public boolean equals(Lesson lesson) {
        return (this.getTerm().equals(lesson.getTerm()) &&
                this.getName().equals(lesson.getName()) &&
                this.getTeacherName().equals(lesson.getTeacherName()) &&
                this.getYear() == lesson.getYear() &&
                this.isFull_time() == lesson.isFull_time());
    }

    public String toString() {
        return getName() + " (" + this.getTerm() + ")\n" + "rok: " + this.getYear() + ", stacjonarne: " + this.isFull_time() + "\nProwadzący: " + getTeacherName();
    }

    public boolean earlierDay() {
//        if (this.isFull_time()) {
//            if (this.getTerm().getDay() == Day.MON) return false;
//        } else {
//            if (this.getTerm().getDay() == Day.FRI) return false;
//            if (this.getTerm().getDay() == Day.SAT && this.getTerm().getStartInMinutes() - this.getTerm().getDuration() < 17*60) return false;
//        }
        Term cand = this.getTerm().earlierDay();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
            return true;
        } else {
            return false;
        }
    }

    public boolean laterDay() {
//        if (this.isFull_time()) {
//            if (this.getTerm().getDay() == Day.FRI) return false;
//            if (this.getTerm().getDay() == Day.THU && this.getTerm().getEndInMinutes() + this.getTerm().getDuration() > 20*60) return false;
//        } else {
//            if (this.getTerm().getDay() == Day.SUN) return false;
//        }
        Term cand = this.getTerm().laterDay();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
            return true;
        } else {
            return false;
        }
    }

    public boolean earlierTime() {
//        if (this.getTerm().getStartInMinutes() - this.getTerm().getDuration() < 8*60) return false;
//        if (!this.isFull_time() && this.getTerm().getDay() == Day.FRI && this.getTerm().getStartInMinutes() - this.getTerm().getDuration() < 17*60) return false;
        Term cand = this.getTerm().startTerm();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
            return true;
        } else {
            return false;
        }
    }

    public boolean laterTime() {
//        if (this.getTerm().getEndInMinutes() + this.getTerm().getDuration() > 20*60) return false;
//        if (this.isFull_time() && this.getTerm().getDay() == Day.FRI && this.getTerm().getStartInMinutes() + this.getTerm().getDuration() > 17*60) return false;
        Term cand = this.getTerm().endTerm();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
            return true;
        } else {
            return false;
        }
    }

    public void applyActions(Action[] actions) {
        for (Action a : actions) {
            this.applyAction(a);
        }
    }

    public void applyAction(Action action) {
        switch (action) {
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

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFull_time() {
        return full_time;
    }

    public void setFull_time(boolean full_time) {
        this.full_time = full_time;
    }
}

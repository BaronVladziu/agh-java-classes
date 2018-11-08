package lab3;

import lab2.Action;
import lab2.Term;
import lab4.ITimetable;
import lab6.ActionFailedException;

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

    public void earlierDay() throws ActionFailedException { //TODO: Rzuć wyjątek
        Term cand = this.getTerm().earlierDay();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to earlier day failed.");
        }
    }

    public void laterDay() throws ActionFailedException {
        Term cand = this.getTerm().laterDay();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to later day failed.");
        }
    }

    public void earlierTime() throws ActionFailedException {
        Term cand = this.getTerm().startTerm();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to earlier time failed.");
        }
    }

    public void earlierTime(int shift) throws ActionFailedException {
        Term cand = this.getTerm().startTerm(shift);
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to earlier time failed.");
        }
    }

    public void laterTime() throws ActionFailedException {
        Term cand = this.getTerm().endTerm();
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to later time failed.");
        }
    }

    public void laterTime(int shift) throws ActionFailedException {
        Term cand = this.getTerm().endTerm(shift);
        if (this.timetable != null && this.timetable.canBeTransferredTo(cand, this.full_time)) {
            this.setTerm(cand);
        } else {
            throw new ActionFailedException("Switching lesson to later time failed.");
        }
    }

    public void applyActions(Action[] actions) throws ActionFailedException {
        for (Action a : actions) {
            this.applyAction(a);
        }
    }

    public void applyAction(Action action) throws ActionFailedException {
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

    public void applyAction(Action action, int upShift, int downShift) throws ActionFailedException {
        switch (action) {
            case DAY_LATER: {
                this.laterDay();
                break;
            }
            case TIME_LATER: {
                this.laterTime(downShift);
                break;
            }
            case DAY_EARLIER: {
                this.earlierDay();
                break;
            }
            case TIME_EARLIER: {
                this.earlierTime(upShift);
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

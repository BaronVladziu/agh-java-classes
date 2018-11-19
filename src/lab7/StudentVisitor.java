package lab7;

import lab2.Day;

public class StudentVisitor implements TimetableElementVisitor {

    private final int year;
    private final boolean full_time;
    private final Day day;

    public StudentVisitor(int year, boolean full_time, Day day) {
        this.year = year;
        this.full_time = full_time;
        this.day = day;
    }

}

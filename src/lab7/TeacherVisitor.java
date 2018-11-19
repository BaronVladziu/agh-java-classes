package lab7;

import lab2.Day;

public class TeacherVisitor implements TimetableElementVisitor {

    private final String name;
    private final Day day;

    public TeacherVisitor(String name, Day day) {
        this.name = name;
        this.day = day;
    }



}

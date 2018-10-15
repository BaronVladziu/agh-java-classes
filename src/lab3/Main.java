package lab3;

import lab2.Day;

public class Main {

    public static void main(String[] args) {
        Lesson lesson = new Lesson(new Term(8, 0, Day.MON),
                "Programowanie obiektowe", "Stanisław Polak", 2);
        System.out.println(lesson);
    }

}

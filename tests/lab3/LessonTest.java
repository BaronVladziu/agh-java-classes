package lab3;

import lab2.Day;
import lab2.Term;
import lab4.Timetable1;
import lab6.ActionFailedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {

    private Timetable1 timetable = new Timetable1();
    private Lesson lesson1 = new Lesson(timetable, new Term(9,15, Day.MON),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson2 = new Lesson(timetable, new Term(15,30, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson3 = new Lesson(timetable, new Term(17,0, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);
    private Lesson lesson4 = new Lesson(timetable, new Term(18,25, Day.SUN),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);

    @Test
    void earlierDay() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertEquals(4, this.timetable.getNumberOfLessons());

        Lesson temp = lesson1.clone();
        try {
            temp.earlierDay();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to earlier day failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(9,15, Day.MON),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson2.clone();
        try {
            temp.earlierDay();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(15,30, Day.THU),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson3.clone();
        try {
            temp.earlierDay();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to earlier day failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(17,0, Day.FRI),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
        temp = lesson4.clone();
        try {
            temp.earlierDay();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(18,25, Day.SAT),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void laterDay() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertEquals(4, this.timetable.getNumberOfLessons());

        Lesson temp = lesson1.clone();
        try {
            temp.laterDay();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(9,15, Day.TUE),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson2.clone();
        try {
            temp.laterDay();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to later day failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(15,30, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson3.clone();
        try {
            temp.laterDay();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(17,0, Day.SAT),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
        temp = lesson4.clone();
        try {
            temp.laterDay();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to later day failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(18,25, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void earlierTime() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertEquals(4, this.timetable.getNumberOfLessons());

        Lesson temp = lesson1.clone();
        try {
            temp.earlierTime();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to earlier time failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(9,15, Day.MON),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson2.clone();
        try {
            temp.earlierTime();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(14,0, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson3.clone();
        try {
            temp.earlierTime();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to earlier time failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(17,0, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
        temp = lesson4.clone();
        try {
            temp.earlierTime();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(16,55, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void laterTime() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertEquals(4, this.timetable.getNumberOfLessons());

        Lesson temp = lesson1.clone();
        try {
            temp.laterTime();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(10,45, Day.MON),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson2.clone();
        try {
            temp.laterTime();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to later time failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(15,30, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));
        temp = lesson3.clone();
        try {
            temp.laterTime();
        } catch (ActionFailedException ex) {}
        assertTrue(new Lesson(timetable, new Term(18,30, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
        temp = lesson4.clone();
        try {
            temp.laterTime();
        } catch (ActionFailedException ex) {
            assertEquals("Switching lesson to later time failed.", ex.getMessage());
        }
        assertTrue(new Lesson(timetable, new Term(18,25, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

}
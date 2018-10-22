package lab3;

import lab2.Day;
import lab2.Term;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {

    private Lesson lesson1 = new Lesson(new Term(9,15, Day.MON),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson2 = new Lesson(new Term(15,40, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson3 = new Lesson(new Term(17,0, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);
    private Lesson lesson4 = new Lesson(new Term(18,25, Day.SUN),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);

    @Test
    void earlierDay() {
        Lesson temp = lesson1.clone();
        assertFalse(temp.earlierDay());
        assertTrue(new Lesson(new Term(9,15, Day.MON),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson2.clone();
        assertTrue(temp.earlierDay());
        assertTrue(new Lesson(new Term(15,40, Day.THU),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson3.clone();
        assertFalse(temp.earlierDay());
        assertTrue(new Lesson(new Term(17,0, Day.FRI),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));

        temp = lesson4.clone();
        assertTrue(temp.earlierDay());
        assertTrue(new Lesson(new Term(18,25, Day.SAT),
                        "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void laterDay() {
        Lesson temp = lesson1.clone();
        assertTrue(temp.laterDay());
        assertTrue(new Lesson(new Term(9,15, Day.TUE),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson2.clone();
        assertFalse(temp.laterDay());
        assertTrue(new Lesson(new Term(15,40, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson3.clone();
        assertTrue(temp.laterDay());
        assertTrue(new Lesson(new Term(17,0, Day.SAT),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));

        temp = lesson4.clone();
        assertFalse(temp.laterDay());
        assertTrue(new Lesson(new Term(18,25, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void earlierTime() {
        Lesson temp = lesson1.clone();
        assertFalse(temp.earlierTime());
        assertTrue(new Lesson(new Term(9,15, Day.MON),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson2.clone();
        assertTrue(temp.earlierTime());
        assertTrue(new Lesson(new Term(14,10, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson3.clone();
        assertFalse(temp.earlierTime());
        assertTrue(new Lesson(new Term(17,0, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));

        temp = lesson4.clone();
        assertTrue(temp.earlierTime());
        assertTrue(new Lesson(new Term(16,55, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

    @Test
    void laterTime() {
        Lesson temp = lesson1.clone();
        assertTrue(temp.laterTime());
        assertTrue(new Lesson(new Term(10,45, Day.MON),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson2.clone();
        assertFalse(temp.laterTime());
        assertTrue(new Lesson(new Term(15,40, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, true).equals(temp));

        temp = lesson3.clone();
        assertTrue(temp.laterTime());
        assertTrue(new Lesson(new Term(18,30, Day.FRI),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));

        temp = lesson4.clone();
        assertFalse(temp.laterTime());
        assertTrue(new Lesson(new Term(18,25, Day.SUN),
                "Programowanie  w języku Ruby","Stanisław Polak",2, false).equals(temp));
    }

}
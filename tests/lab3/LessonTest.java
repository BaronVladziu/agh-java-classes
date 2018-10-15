package lab3;

import lab2.Day;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {

    private Lesson lesson = new Lesson(new Term(9,35, Day.TUE),"Programowanie  w języku Ruby","Stanisław Polak",2);

    @Test
    void earlierDay() {
        Lesson lesson2 = lesson.clone();
        lesson2.earlierDay();
        assertEquals(new Lesson(new Term(9,35, Day.MON), "Programowanie  w języku Ruby","Stanisław Polak",2), lesson2);
    }

    @Test
    void laterDay() {
    }

    @Test
    void earlierTime() {
    }

    @Test
    void laterTime() {
    }

}
package lab5;

import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Timetable2Test {

    private Break[] breaks = new Break[6];
    private Term break0 = new Term(9, 30, Day.MON);
    private Term break1 = new Term(11, 5, Day.MON);
    private Term break2 = new Term(12, 45, Day.MON);
    private Term break3 = new Term(14, 20, Day.MON);
    private Term break4 = new Term(16, 10, Day.MON);
    private Term break5 = new Term(17, 45, Day.MON);
    private Timetable2 timetable = new Timetable2(breaks);
    private Lesson lesson1 = new Lesson(timetable, new Term(9,35, Day.MON),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson2 = new Lesson(timetable, new Term(14,40, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, true);
    private Lesson lesson3 = new Lesson(timetable, new Term(17,50, Day.FRI),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);
    private Lesson lesson4 = new Lesson(timetable, new Term(17,50, Day.SUN),
            "Programowanie  w języku Ruby","Stanisław Polak",2, false);

    @Test
    void canBeTransferredTo() {
        break0.setDuration(5);
        break1.setDuration(10);
        break2.setDuration(5);
        break3.setDuration(20);
        break4.setDuration(5);
        break5.setDuration(5);
        breaks[0] = new Break(break0);
        breaks[1] = new Break(break1);
        breaks[2] = new Break(break2);
        breaks[3] = new Break(break3);
        breaks[4] = new Break(break4);
        breaks[5] = new Break(break5);
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);

        assertFalse(this.timetable.canBeTransferredTo(new Term(7, 0, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(19, 0, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(10, 0, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(9, 35, Day.MON), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(9, 35, Day.TUE), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(11, 15, Day.MON), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(8, 0, Day.TUE), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(18, 30, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(17, 50, Day.SUN), false));
        assertFalse(this.timetable.canBeTransferredTo(new Term(9, 35, Day.SUN), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(9, 35, Day.TUE), false));
    }

    @Test
    void busy() {
        break0.setDuration(5);
        break1.setDuration(10);
        break2.setDuration(5);
        break3.setDuration(20);
        break4.setDuration(5);
        break5.setDuration(5);
        breaks[0] = new Break(break0);
        breaks[1] = new Break(break1);
        breaks[2] = new Break(break2);
        breaks[3] = new Break(break3);
        breaks[4] = new Break(break4);
        breaks[5] = new Break(break5);
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);

        assertTrue(this.timetable.busy(new Term(9, 35, Day.MON)));
        assertTrue(this.timetable.busy(new Term(17, 50, Day.SUN)));
        assertFalse(this.timetable.busy(new Term(12, 30, Day.FRI)));
        assertFalse(this.timetable.busy(new Term(19, 30, Day.FRI)));
        assertFalse(this.timetable.busy(new Term(9, 0, Day.TUE)));
    }

    @Test
    void put() {
        break0.setDuration(5);
        break1.setDuration(10);
        break2.setDuration(5);
        break3.setDuration(20);
        break4.setDuration(5);
        break5.setDuration(5);
        breaks[0] = new Break(break0);
        breaks[1] = new Break(break1);
        breaks[2] = new Break(break2);
        breaks[3] = new Break(break3);
        breaks[4] = new Break(break4);
        breaks[5] = new Break(break5);

        try {
            assertEquals(0, this.timetable.getNumberOfLessons());
            assertTrue(this.timetable.put(lesson1));
            assertEquals(1, this.timetable.getNumberOfLessons());
            assertTrue(this.timetable.put(lesson2));
            assertEquals(2, this.timetable.getNumberOfLessons());
            assertTrue(this.timetable.put(lesson3));
            assertEquals(3, this.timetable.getNumberOfLessons());
            assertTrue(this.timetable.put(lesson4));
        } catch (IllegalArgumentException e) {}
        assertEquals(4, this.timetable.getNumberOfLessons());
        try {
            assertFalse(this.timetable.put(new Lesson(this.timetable, new Term(9, 35, Day.MON),
                    "Programowanie  w języku Ruby", "Stanisław Polak", 2, true)));
        } catch (IllegalArgumentException e) {
            assertEquals("Unable to put lesson to timetable", e.getMessage());
        }
        assertEquals(4, this.timetable.getNumberOfLessons());
        try {
            assertFalse(this.timetable.put(new Lesson(this.timetable, new Term(9, 15, Day.TUE),
                    "Programowanie  w języku Ruby", "Stanisław Polak", 2, true)));
        } catch (IllegalArgumentException e) {
            assertEquals("Unable to put lesson to timetable", e.getMessage());
        }
        assertEquals(4, this.timetable.getNumberOfLessons());
    }

    @Test
    void get() {
        break0.setDuration(5);
        break1.setDuration(10);
        break2.setDuration(5);
        break3.setDuration(20);
        break4.setDuration(5);
        break5.setDuration(5);
        breaks[0] = new Break(break0);
        breaks[1] = new Break(break1);
        breaks[2] = new Break(break2);
        breaks[3] = new Break(break3);
        breaks[4] = new Break(break4);
        breaks[5] = new Break(break5);
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);

        assertEquals(lesson1, this.timetable.get(new Term(9,35, Day.MON)));
        assertEquals(lesson2, this.timetable.get(new Term(14,40, Day.FRI)));
        assertEquals(lesson3, this.timetable.get(new Term(17,50, Day.FRI)));
        assertNull(this.timetable.get(new Term(11,15, Day.MON)));
    }

    @Test
    void repeatedChar() {
        assertEquals("ccccc", this.timetable.repeatedChar('c', 5));
        assertEquals("sss", this.timetable.repeatedChar('s', 3));
        assertEquals("88", this.timetable.repeatedChar('8', 2));
    }

    @Test
    void fitInto() {
        String s = "abc";
        assertEquals(15, this.timetable.fitInto(s, 15).length());
        assertEquals(3, this.timetable.fitInto(s, 3).length());
        assertEquals(2, this.timetable.fitInto(s, 2).length());
    }
}
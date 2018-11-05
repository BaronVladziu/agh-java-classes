package lab4;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import org.junit.jupiter.api.Test;

import static lab2.Action.*;
import static org.junit.jupiter.api.Assertions.*;

class Timetable1Test {

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
    void canBeTransferredTo() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertFalse(this.timetable.canBeTransferredTo(new Term(7, 0, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(19, 0, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(10, 0, Day.MON), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(9, 0, Day.TUE), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(11, 0, Day.MON), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(8, 0, Day.TUE), true));
        assertTrue(this.timetable.canBeTransferredTo(new Term(18, 30, Day.TUE), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(17, 0, Day.SUN), false));
        assertFalse(this.timetable.canBeTransferredTo(new Term(9, 0, Day.SUN), true));
        assertFalse(this.timetable.canBeTransferredTo(new Term(9, 0, Day.TUE), false));
    }

    @Test
    void busy() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertTrue(this.timetable.busy(new Term(10, 0, Day.MON)));
        assertTrue(this.timetable.busy(new Term(17, 0, Day.SUN)));
        assertFalse(this.timetable.busy(new Term(14, 0, Day.FRI)));
        assertFalse(this.timetable.busy(new Term(18, 30, Day.FRI)));
        assertFalse(this.timetable.busy(new Term(9, 0, Day.TUE)));
    }

    @Test
    void put() {
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
            assertFalse(this.timetable.put(new Lesson(this.timetable, new Term(9, 15, Day.MON),
                    "Programowanie  w języku Ruby", "Stanisław Polak", 2, true)));
        } catch (IllegalArgumentException e) {
            assertEquals("Unable to put lesson to timetable", e.getMessage());
        }
        assertEquals(4, this.timetable.getNumberOfLessons());
    }

    @Test
    void perform() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);

        Action[] actions = {TIME_LATER, DAY_EARLIER, TIME_EARLIER, DAY_LATER};
        this.timetable.perform(actions);
        assertEquals(new Term(10,45, Day.MON).toString(), lesson1.getTerm().toString());
        assertEquals(new Term(15,30, Day.THU).toString(), lesson2.getTerm().toString());
        assertEquals(new Term(17,0, Day.FRI).toString(), lesson3.getTerm().toString());
        assertEquals(new Term(18,25, Day.SUN).toString(), lesson4.getTerm().toString());

        Action[] actions2 = {TIME_LATER, DAY_EARLIER, DAY_LATER, TIME_EARLIER};
        this.timetable.perform(actions2);
        assertEquals(new Term(12,15, Day.MON).toString(), lesson1.getTerm().toString());
        assertEquals(new Term(15,30, Day.WEN).toString(), lesson2.getTerm().toString());
        assertEquals(new Term(17,0, Day.SAT).toString(), lesson3.getTerm().toString());
        assertEquals(new Term(16,55, Day.SUN).toString(), lesson4.getTerm().toString());
    }

    @Test
    void get() {
        this.timetable.put(lesson1);
        this.timetable.put(lesson2);
        this.timetable.put(lesson3);
        this.timetable.put(lesson4);
        assertEquals(lesson1, this.timetable.get(new Term(9,15, Day.MON)));
        assertEquals(lesson2, this.timetable.get(new Term(15,15, Day.FRI)));
        assertEquals(lesson3, this.timetable.get(new Term(18,15, Day.FRI)));
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
package lab3;

import lab2.Day;
import lab2.Term;
import lab4.Timetable1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    Timetable1 timetable = new Timetable1();
    Lesson lesson = new Lesson(timetable, new Term(8, 0, Day.MON),
            "Programowanie obiektowe", "Stanisław Polak", 2, true);
    ActionsParser parser = new ActionsParser();

    @Test
    void dPlus() {
        timetable.put(lesson);
        String[] args = {"d+"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Wtorek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void dMinus() {
        timetable.put(lesson);
        String[] args = {"d-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void tPlus() {
        timetable.put(lesson);
        String[] args = {"t+"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 9:30-11:00)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void tMinus() {
        timetable.put(lesson);
        String[] args = {"t-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void circle() {
        timetable.put(lesson);
        String[] args = {"t+", "d+", "d-", "t-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

}

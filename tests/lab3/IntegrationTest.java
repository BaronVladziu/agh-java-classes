package lab3;

import lab2.Day;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    Lesson lesson = new Lesson(new Term(8, 0, Day.MON),
            "Programowanie obiektowe", "Stanisław Polak", 2);
    ActionsParser parser = new ActionsParser();

    @Test
    void dPlus() {
        String[] args = {"d+"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Wtorek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void dMinus() {
        String[] args = {"d-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void tPlus() {
        String[] args = {"t+"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 9:30-11:00)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void tMinus() {
        String[] args = {"t-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

    @Test
    void circle() {
        String[] args = {"t+", "d+", "d-", "t-"};
        lesson.applyActions(parser.parse(args));
        assertEquals("Programowanie obiektowe (Poniedziałek 8:00-9:30)\n" +
                        "rok: 2, stacjonarne: true\n" +
                        "Prowadzący: Stanisław Polak",
                lesson.toString());
    }

}

package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

    private Term term1 = new Term(9,45);
    private Term term2 = new Term(10,15);

    @Test
    void toStringTest() {
        assertEquals("9:45 [90]", term1.toString());
        assertEquals("10:15 [90]", term2.toString());
    }

    @Test
    void getStartInMinutes() {
        assertEquals(9*60 + 45, term1.getStartInMinutes());
        assertEquals(10*60 + 15, term2.getStartInMinutes());
    }

    @Test
    void earlierThan() {
        assertTrue(term1.earlierThan(term2));
        assertFalse(term2.earlierThan(term1));
        assertFalse(term1.earlierThan(term1));
    }

    @Test
    void laterThan() {
        assertFalse(term1.laterThan(term2));
        assertTrue(term2.laterThan(term1));
        assertFalse(term1.laterThan(term1));
    }

    @Test
    void endTerm() {
        Term tempTerm = term1.endTerm(term2);
        assertEquals(9, tempTerm.hour);
        assertEquals(45, tempTerm.minute);
        assertEquals(30, tempTerm.duration);
    }

    @Test
    void endTerm1() {
        Term tempTerm = term1.endTerm();
        assertEquals(11, tempTerm.hour);
        assertEquals(15, tempTerm.minute);
        assertEquals(90, tempTerm.duration);
    }
}
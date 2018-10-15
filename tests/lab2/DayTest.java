package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    private Day day = Day.MON;

    @Test
    void nextDay() {
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.TUE);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.WEN);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.THU);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.FRI);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.SAT);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.SUN);
        this.day = this.day.nextDay();
        assertEquals(this.day, Day.MON);
    }

    @Test
    void prevDay() {
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.SUN);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.SAT);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.FRI);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.THU);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.WEN);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.TUE);
        this.day = this.day.prevDay();
        assertEquals(this.day, Day.MON);
    }
}
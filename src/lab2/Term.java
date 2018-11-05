package lab2;

import lab5.BasicTerm;

public class Term extends BasicTerm {

    private Day day;

    public Term(int hour, int minute, Day day) {
        super(hour, minute);
        this.setDay(day);
    }

    public Term(int hour, int minute, int duration, Day day) {
        super(hour, minute, duration);
        this.setDay(day);
    }

    public Term(int startInMinutes, Day day) {
        super(startInMinutes);
        this.setDay(day);
    }

    public String toString() {
        Term endTerm = this.endTerm();
        return this.getDay() + " " + super.toString();
    }

    public boolean equals(Term termin) {
        return (super.equals(termin) && this.day == termin.day);
    }

    public Term endTerm(Term termin) {
        BasicTerm resultTerm = super.endTerm(termin);
        return new Term(resultTerm.getHour(), resultTerm.getMinute(), resultTerm.getDuration(), this.day);
    }

    public Term endTerm() {
        BasicTerm resultTerm = super.endTerm();
        return new Term(resultTerm.getHour(), resultTerm.getMinute(), resultTerm.getDuration(), this.day);
    }

    public Term endTerm(int additionalShiftInMinutes) {
        BasicTerm resultTerm = super.endTerm(additionalShiftInMinutes);
        return new Term(resultTerm.getHour(), resultTerm.getMinute(), resultTerm.getDuration(), this.day);
    }

    public Term startTerm() {
        BasicTerm resultTerm = super.startTerm();
        return new Term(resultTerm.getHour(), resultTerm.getMinute(), resultTerm.getDuration(), this.day);
    }

    public Term startTerm(int additionalShiftInMinutes) {
        BasicTerm resultTerm = super.startTerm(additionalShiftInMinutes);
        return new Term(resultTerm.getHour(), resultTerm.getMinute(), resultTerm.getDuration(), this.day);
    }

    public Term earlierDay() {
        Term result = this.clone();
        result.setDay(result.getDay().prevDay());
        return result;
    }

    public Term laterDay() {
        Term result = this.clone();
        result.setDay(result.getDay().nextDay());
        return result;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Term clone() {
        return new Term(this.hour, this.minute, this.duration, this.day);
    }

    @Override
    public int hashCode() {
        return super.hashCode()*10 + day.ordinal();
    }
}

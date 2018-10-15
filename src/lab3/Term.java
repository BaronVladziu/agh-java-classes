package lab3;

import lab2.Day;

public class Term {

    int hour; //godzina rozpoczęcia zajęć
    int minute; //minuta rozpoczęcia zajęć
    int duration; //czas trwania zajęć (w minutach)
    Day day;

    Term(int hour, int minute, Day day) {
        this.hour = hour;
        this.minute = minute;
        this.duration = 90;
        this.day = day;
    }

    Term(int startInMinutes, Day day) {
        this.hour = startInMinutes / 60;
        this.minute = startInMinutes % 60;
        this.duration = 90;
        this.day = day;
    }

    public String toString() {
        return Integer.toString(hour) + ":" + Integer.toString(minute) + " [" + Integer.toString(duration) + "]";
    }

    int getStartInMinutes() {
        return this.hour * 60 + this.minute;
    }

    boolean earlierThan(Term termin) {
        return (this.getStartInMinutes() < termin.getStartInMinutes());
    }

    boolean laterThan(Term termin) {
        return (this.getStartInMinutes() > termin.getStartInMinutes());
    }

    boolean equals(Term termin) {
        return (this.getStartInMinutes() == termin.getStartInMinutes() && this.duration == termin.duration);
    }

    Term endTerm(Term termin) {
        Term resultTerm = new Term(this.hour, this.minute);
        resultTerm.duration = termin.getStartInMinutes() - this.getStartInMinutes();
        return resultTerm;
    }

    Term endTerm() {
        Term resultTerm = new Term(this.getStartInMinutes() + this.duration);
        resultTerm.duration = this.duration;
        return resultTerm;
    }

}

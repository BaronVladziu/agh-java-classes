package lab2;

public class Term {

    private int hour; //godzina rozpoczęcia zajęć
    private int minute; //minuta rozpoczęcia zajęć
    private int duration; //czas trwania zajęć (w minutach)
    private Day day;

    public Term(int hour, int minute, Day day) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setDuration(90);
        this.setDay(day);
    }

    public Term(int startInMinutes, Day day) {
        this.setHour(startInMinutes / 60);
        this.setMinute(startInMinutes % 60);
        this.setDuration(90);
        this.setDay(day);
    }

    public String toString() {
        Term endTerm = this.endTerm();
        return this.getDay() + " " + getHour() + ":" + String.format("%02d", getMinute()) + "-" + endTerm.getHour() + ":" + String.format("%02d", endTerm.getMinute());
    }

    public int getStartInMinutes() {
        return this.getHour() * 60 + this.getMinute();
    }

    public int getEndInMinutes() {
        return this.getHour() * 60 + this.getMinute() + this.getDuration();
    }

    public boolean earlierThan(Term termin) {
        return (this.getStartInMinutes() < termin.getStartInMinutes());
    }

    public boolean laterThan(Term termin) {
        return (this.getStartInMinutes() > termin.getStartInMinutes());
    }

    public boolean equals(Term termin) {
        return (this.getStartInMinutes() == termin.getStartInMinutes() && this.getDuration() == termin.getDuration());
    }

    public Term endTerm(Term termin) {
        Term resultTerm = new Term(this.getHour(), this.getMinute(), this.getDay());
        resultTerm.setDuration(termin.getStartInMinutes() - this.getStartInMinutes());
        return resultTerm;
    }

    public Term endTerm() {
        Term resultTerm = new Term(this.getStartInMinutes() + this.getDuration(), this.getDay());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
    }

    public Term startTerm() {
        Term resultTerm = new Term(this.getStartInMinutes() - this.getDuration(), this.getDay());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
    }

    public Term earlierDay() {
        Term result = this.clone();
        result.getDay().prevDay();
        return result;
    }

    public Term laterDay() {
        Term result = this.clone();
        result.getDay().nextDay();
        return result;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Term clone() {
        Term result = new Term(this.hour, this.minute, this.day);
        result.duration = this.duration;
        return result;
    }
}

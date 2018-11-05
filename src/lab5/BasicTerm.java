package lab5;

public class BasicTerm {

    protected int hour; //godzina rozpoczęcia zajęć
    protected int minute; //minuta rozpoczęcia zajęć
    protected int duration; //czas trwania zajęć (w minutach)

    public BasicTerm(int hour, int minute) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setDuration(90);
    }

    public BasicTerm(int hour, int minute, int duration) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setDuration(duration);
    }

    public BasicTerm(int startInMinutes) {
        this.setHour(startInMinutes / 60);
        this.setMinute(startInMinutes % 60);
        this.setDuration(90);
    }

    public String toString() {
        BasicTerm endTerm = this.endTerm();
        return this.getHour() + ":" + String.format("%02d", this.getMinute()) + "-" + endTerm.getHour() + ":" + String.format("%02d", endTerm.getMinute());
    }

    public int getStartInMinutes() {
        return this.getHour() * 60 + this.getMinute();
    }

    public int getEndInMinutes() {
        return this.getHour() * 60 + this.getMinute() + this.getDuration();
    }

    public boolean earlierThan(BasicTerm termin) {
        return (this.getStartInMinutes() < termin.getStartInMinutes());
    }

    public boolean laterThan(BasicTerm termin) {
        return (this.getStartInMinutes() > termin.getStartInMinutes());
    }

    public boolean equals(BasicTerm termin) {
        return (this.getStartInMinutes() == termin.getStartInMinutes() && this.getDuration() == termin.getDuration());
    }

    public BasicTerm endTerm(BasicTerm termin) {
        BasicTerm resultTerm = new BasicTerm(this.getHour(), this.getMinute());
        resultTerm.setDuration(termin.getStartInMinutes() - this.getStartInMinutes());
        return resultTerm;
    }

    public BasicTerm endTerm() {
        BasicTerm resultTerm = new BasicTerm(this.getStartInMinutes() + this.getDuration());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
    }

    public BasicTerm endTerm(int additionalShiftInMinutes) {
        BasicTerm resultTerm = new BasicTerm(this.getStartInMinutes() + additionalShiftInMinutes + this.getDuration());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
    }

    public BasicTerm startTerm() {
        BasicTerm resultTerm = new BasicTerm(this.getStartInMinutes() - this.getDuration());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
    }

    public BasicTerm startTerm(int additionalShiftInMinutes) {
        BasicTerm resultTerm = new BasicTerm(this.getStartInMinutes() - additionalShiftInMinutes - this.getDuration());
        resultTerm.setDuration(this.getDuration());
        return resultTerm;
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

    public BasicTerm clone() {
        BasicTerm result = new BasicTerm(this.hour, this.minute);
        result.duration = this.duration;
        return result;
    }

    public boolean ifHoursCollide(BasicTerm term) {
        return !(this.getStartInMinutes() >= term.getEndInMinutes() ||
                this.getEndInMinutes() <= term.getStartInMinutes());
    }

    @Override
    public int hashCode() {
        return (60*hour + minute)*1000 + duration;
    }
}

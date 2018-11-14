package lab6;

public class TimetableAnswer {

    public final boolean ifAgreed;
    public final int shift;

    public TimetableAnswer(boolean ifAgreed) {
        this.ifAgreed = ifAgreed;
        this.shift = 0;
    }

    public TimetableAnswer(boolean ifAgreed, int shift) {
        this.ifAgreed = ifAgreed;
        this.shift = shift;
    }

}

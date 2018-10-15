package lab2;

public enum Day {
    MON,
    TUE,
    WEN,
    THU,
    FRI,
    SAT,
    SUN,
    UNK;

    public String toString() {
        switch (this) {
            case MON: return "Poniedziałek";
            case TUE: return "Wtorek";
            case WEN: return "Środa";
            case THU: return "Czwartek";
            case FRI: return "Piątek";
            case SAT: return "Sobota";
            case SUN: return "Niedziela";
            default: return "UNK";
        }
    }

    public Day nextDay() {
        switch (this) {
            case MON: return TUE;
            case TUE: return WEN;
            case WEN: return THU;
            case THU: return FRI;
            case FRI: return SAT;
            case SAT: return SUN;
            case SUN: return MON;
            default: return UNK;
        }
    }

    public Day prevDay() {
        switch (this) {
            case MON: return SUN;
            case TUE: return MON;
            case WEN: return TUE;
            case THU: return WEN;
            case FRI: return THU;
            case SAT: return FRI;
            case SUN: return SAT;
            default: return UNK;
        }
    }

}

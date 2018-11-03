package lab5;

public class Break {

    private BasicTerm term;

    public Break(BasicTerm term) {
        this.term = term.clone();
    }

    public String toString() {
        return "Przerwa";
    }

    public BasicTerm getTerm() {
        return term.clone();
    }

}

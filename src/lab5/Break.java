package lab5;

import lab7.VisitableTimetableElement;

public class Break implements VisitableTimetableElement{

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

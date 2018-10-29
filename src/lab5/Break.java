package lab5;

import lab2.Term;

public class Break {

    private Term term;

    public Break(Term term) {
        this.term = term.clone();
    }

    public String toString() {
        return "Przerwa";
    }

    public Term getTerm() {
        return term.clone();
    }

}

package lab7;

public interface VisitableTimetableElement {

    public void accept(TimetableElementVisitor visitor);

}

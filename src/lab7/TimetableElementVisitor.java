package lab7;

import lab3.Lesson;
import lab5.Break;

public interface TimetableElementVisitor {

    public void visit(Lesson lesson);
    public void visit(Break brk);

}

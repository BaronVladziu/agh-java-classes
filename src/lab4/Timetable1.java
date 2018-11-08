package lab4;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab5.AbstractTimetable;
import lab6.ActionFailedException;

import java.util.ArrayList;

public class Timetable1 extends AbstractTimetable {

    public int getNumberOfLessons() {
        return this.lessons.size();
    }

    public void perform(Action[] actions) {
        int lID = 0;
        Object[] lessonList = lessons.values().toArray();
        for (Action a : actions) {
            Lesson l = (Lesson)lessonList[lID];
            lessons.remove(l.getTerm().hashCode());
            try {
                l.applyAction(a);
            } catch (ActionFailedException ex) {
                System.out.println(ex.getMessage());
            }
            lessons.put(l.getTerm().hashCode(), l);
            lID++;
            if (lID > lessons.size()) {
                lID = 0;
            }
        }
    }

}

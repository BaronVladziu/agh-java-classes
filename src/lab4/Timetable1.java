package lab4;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab5.AbstractTimetable;

import java.util.ArrayList;

public class Timetable1 extends AbstractTimetable {

    public int getNumberOfLessons() {
        return this.lessons.size();
    }

    public void perform(Action[] actions) {
        int lID = 0;
        for (Action a : actions) {
            Lesson l = lessons.get(lID);
            lessons.remove(l.getTerm().hashCode());
            l.applyAction(a);
            lessons.put(l.getTerm().hashCode(), l);
            lID++;
            if (lID > lessons.size()) {
                lID = 0;
            }
        }
    }

}

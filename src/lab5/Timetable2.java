package lab5;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab4.ITimetable;

import java.util.ArrayList;

public class Timetable2 extends AbstractTimetable {

    private static boolean SKIP_BREAKS = true;

    private Break[] breaks;

    Timetable2(Break[] breaks) {
        this.breaks = breaks;
    }

    public boolean canBeTransferredTo(Term term, boolean full_time) {
        for (Break b : this.breaks) {
            if (term.ifHoursCollide(b.getTerm())) return false;
        }
        return super.canBeTransferredTo(term, full_time);
    }

    public int getNumberOfLessons() {
        return this.lessons.size();
    }

    public void perform(Action[] actions) {
        int lID = 0;
        for (Action a : actions) {
            Lesson act = lessons.get(lID);
            if (SKIP_BREAKS) {
                int upShift = 0;
                int downShift = 0;
                for (Break b : this.breaks) {
                    if (b.getTerm().getEndInMinutes() == act.getTerm().getStartInMinutes()) {
                        int actDur = b.getTerm().getDuration();
                        if (upShift < actDur) upShift = actDur;
                    } else if (b.getTerm().getStartInMinutes() == act.getTerm().getEndInMinutes()) {
                        int actDur = b.getTerm().getDuration();
                        if (downShift < actDur) downShift = actDur;
                    }
                }
                act.applyAction(a, upShift, downShift);
            } else {
                act.applyAction(a);
            }
            lID++;
            if (lID > lessons.size()) {
                lID = 0;
            }
        }
    }

}

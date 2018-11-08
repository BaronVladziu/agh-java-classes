package lab5;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab6.ActionFailedException;

import java.util.Collection;
import java.util.List;

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
        Object[] lesssonList = lessons.values().toArray();
        int lID = 0;
        for (Action a : actions) {
            Lesson act = (Lesson)lesssonList[lID];
            lessons.remove(act.getTerm().hashCode());
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
                try {
                    act.applyAction(a, upShift, downShift);
                } catch (ActionFailedException ex) {
                    System.out.println(ex.getMessage());
                }

            } else {
                try {
                    act.applyAction(a);
                } catch (ActionFailedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            lessons.put(act.getTerm().hashCode(), act);
            lID++;
            if (lID > lessons.size()) {
                lID = 0;
            }
        }
    }

}

package lab5;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab6.ActionFailedException;
import lab6.TimetableAnswer;

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

    public TimetableAnswer canPerform(Action action, Lesson lesson) {
        Term cand = lesson.getTerm();
        int upShift = 0;
        int downShift = 0;
        if (SKIP_BREAKS) {
            for (Break b : this.breaks) {
                if (b.getTerm().getEndInMinutes() == lesson.getTerm().getStartInMinutes()) {
                    int actDur = b.getTerm().getDuration();
                    if (upShift < actDur) upShift = actDur;
                } else if (b.getTerm().getStartInMinutes() == lesson.getTerm().getEndInMinutes()) {
                    int actDur = b.getTerm().getDuration();
                    if (downShift < actDur) downShift = actDur;
                }
            }
        }
        int shift = 0;
        switch (action) {
            case TIME_EARLIER: {
                shift = upShift;
                break;
            }
            case TIME_LATER: {
                shift = downShift;
                break;
            }
        }
        try {
            cand.applyAction(action, shift);
            if (this.canBeTransferredTo(cand, lesson.isFull_time())) {
                return new TimetableAnswer(true, shift);
            }
        } catch (ActionFailedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return new TimetableAnswer(false);
    }

}

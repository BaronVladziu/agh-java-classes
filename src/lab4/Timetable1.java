package lab4;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.Lesson;

import java.util.ArrayList;

public class Timetable1 implements ITimetable {

    private ArrayList<Lesson> lessons = new ArrayList<>();

    public boolean canBeTransferredTo(Term term, boolean full_time) {
        if (full_time) {
            if (term.getDay() == Day.SAT || term.getDay() == Day.SUN) return false;
            if (term.getDay() == Day.FRI && term.getEndInMinutes() > 17*60) return false;
        } else {
            if (term.getDay() == Day.SAT || term.getDay() == Day.SUN) return true;
            if (term.getDay() == Day.FRI && term.getStartInMinutes() < 17*60) return false;
        }
        return !this.busy(term);
    }

    public boolean busy(Term term) {
        for (Lesson l : lessons) {
            Term t = l.getTerm();
            if (term.getStartInMinutes() >= t.getStartInMinutes() &&
                    term.getStartInMinutes() < t.getEndInMinutes()) return true;
            if (term.getEndInMinutes() >= t.getStartInMinutes() &&
                    term.getEndInMinutes() < t.getEndInMinutes()) return true;
        }
        return false;
    }

    public boolean put(Lesson lesson) {
        if (this.canBeTransferredTo(lesson.getTerm(), lesson.isFull_time())) {
            lessons.add(lesson);
            return true;
        }
        return false;
    }

    public void perform(Action[] actions) {
        int lID = 0;
        for (Action a : actions) {
            lessons.get(lID).applyAction(a);
            lID++;
            if (lID > lessons.size()) {
                lID = 0;
            }
        }
    }

    public Object get(Term term) {
        for (Lesson l : lessons) {
            Term t = l.getTerm();
            if ((term.getStartInMinutes() >= t.getStartInMinutes() &&
                    term.getStartInMinutes() < t.getEndInMinutes()) ||
                    (term.getEndInMinutes() >= t.getStartInMinutes() &&
                    term.getEndInMinutes() < t.getEndInMinutes())) return l;
        }
        return null;
    }

    public String toString() {
        ITimetable timetable = new Timetable1();
        Day firstDay = Day.MON;
        Day lastDay = Day.SUN;
        Term firstTerm = new Term(8,0,firstDay);
        Term lastTerm = new Term(20,0,lastDay);
        Day day = null;
        Term term = null;
        for(day = firstDay ; day.compareTo(lastDay) <= 0 ; day = day.nextDay()){
            System.out.println(day);
            for(term = firstTerm ; term.laterThan(lastTerm) ; term = term.endTerm()){
                System.out.print(term);
                if(timetable.busy(term))
                    System.out.println(timetable.get(term));
                else
                    System.out.println(" ");
            }
        }
    }

}

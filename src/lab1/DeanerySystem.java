package lab1;

import lab2.Action;
import lab2.Day;
import lab2.Term;
import lab3.ActionsParser;
import lab3.Lesson;
import lab4.ITimetable;
import lab4.Timetable1;

public class DeanerySystem {

    public static void main(String[] args) {
        Action[] actions = new ActionsParser().parse(args);
        ITimetable timetable = new Timetable1();
        Lesson l1 = new Lesson(timetable,new Term(8,0,Day.TUE),"Angielski","Nowak",1, true);
        Lesson l2 = new Lesson(timetable,new Term(9,30,Day.MON),"JTP","Kowalski",3, true);
        timetable.put(l1);
        timetable.put(l2);
        timetable.perform(actions);
        System.out.println(timetable);
    }

}

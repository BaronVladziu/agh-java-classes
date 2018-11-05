package lab5;

import lab2.Day;
import lab2.Term;
import lab3.Lesson;
import lab4.ITimetable;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class AbstractTimetable implements ITimetable {

    protected LinkedHashMap<Integer, Lesson> lessons = new LinkedHashMap<>();

    public boolean busy(Term term) {
        return (lessons.containsKey(term.hashCode()));
    }

    public boolean canBeTransferredTo(Term term, boolean full_time) {
        if (full_time) {
            if (term.getDay() == Day.SAT || term.getDay() == Day.SUN) return false;
            if (term.getDay() == Day.FRI && term.getEndInMinutes() > 17*60) return false;
        } else {
            if (term.getDay() != Day.FRI && term.getDay() != Day.SAT && term.getDay() != Day.SUN) return false;
            if (term.getDay() == Day.FRI && term.getStartInMinutes() < 17*60) return false;
        }
        if (term.getStartInMinutes() < 8*60) return false;
        if (term.getEndInMinutes() > 20*60) return false;
        return !this.busy(term);
    }

    public boolean put(Lesson lesson) throws IllegalArgumentException {
        if (this.canBeTransferredTo(lesson.getTerm(), lesson.isFull_time())) {
            lessons.put(lesson.getTerm().hashCode(), lesson);
            return true;
        }
        throw new IllegalArgumentException("Unable to put lesson to timetable");
    }

    public Object get(Term term) {
        return lessons.get(term.hashCode());
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        int lenX = 2*8;
        int lenY = 12*4+3;
        int colLength = 18;
        String wall = this.repeatedChar('*', colLength);
        String[][] table = new String[lenX][lenY];
        //Vertical walls
        for (int i = 1; i < lenX; i+=2) {
            for (int j = 0; j < lenY; j++) {
                table[i][j] = "*";
            }
        }
        //Horizontal walls
        for (int i = 0; i < lenX; i+=2) {
            table[i][1] = wall;
            table[i][lenY-1] = wall;
        }
        //Days
        for (int i = 0; i < lenX/2 - 1; i++) {
            table[2*(i+1)][0] = this.fitInto(Day.values()[i].toString(), colLength);
        }
        //Hours
        for (int j = 0; j < lenY-3; j++) {
            table[0][j+2] = this.repeatedChar(' ', colLength - 5) +
                    String.format("%02d", 8 + j/4) + ':' + String.format("%02d", 15*(j%4));
        }
        //Lessons
        for (Lesson l : lessons.values()) {
            int x = 2*(l.getTerm().getDay().ordinal()) + 2;
            int y = (l.getTerm().getStartInMinutes() - 8*60)/15 + 2;
            int yEnd = (l.getTerm().getEndInMinutes() - 8*60)/15 + 1;
            table[x][y] = this.repeatedChar('-', colLength);
            table[x][y+1] = this.fitInto(l.getName(), colLength);
            table[x][yEnd] = this.repeatedChar('-', colLength);
        }
        //To string
        for (int j = 0; j < lenY; j++) {
            for (int i = 0; i < lenX; i++) {
                if (table[i][j] != null) result.append(table[i][j]);
                else result.append(this.repeatedChar(' ', colLength));
            }
            result.append('\n');
        }
        return result.toString();
    }

    public String repeatedChar(Character c, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(c);
        }
        return result.toString();
    }

    public String fitInto(String s, int size) {
        String result = new String(s);
        if (s.length() > size) {
            s = s.substring(0, size);
        } else {
            s += this.repeatedChar(' ', size - s.length());
        }
        return s;
    }

}

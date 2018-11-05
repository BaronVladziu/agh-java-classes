package lab3;

import lab2.Action;

import java.util.ArrayList;

public class ActionsParser {

    public Action[] parse(String[] tablica) throws IllegalArgumentException {
        ArrayList<Action> aVec = new ArrayList<>();
        for (int i = 0; i < tablica.length; i++) {
            switch (tablica[i]) {
                case "d-": {
                    aVec.add(Action.DAY_EARLIER);
                    break;
                }
                case "d+": {
                    aVec.add(Action.DAY_LATER);
                    break;
                }
                case "t-": {
                    aVec.add(Action.TIME_EARLIER);
                    break;
                }
                case "t+": {
                    aVec.add(Action.TIME_LATER);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Translation " + tablica[i] + " is incorrect");
                }
            }
        }
        Action[] actions = new Action[0];
        return aVec.toArray(actions);
    }

}

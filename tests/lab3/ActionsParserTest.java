package lab3;

import lab2.Action;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionsParserTest {

    private ActionsParser parser = new ActionsParser();

    @Test
    void parse() {
        String[] tab = {"t+", "d-", "t-", "xxx", "d+"};
        try {
            Action[] actions = parser.parse(tab);
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals("Translation xxx is incorrect",
                    illegalArgumentException.getMessage());
        }

        String[] tab2 = {"t+", "d-", "t-", "d+"};
        try {
            Action[] actions = parser.parse(tab2);
            assertEquals(4, actions.length);
            assertEquals(Action.TIME_LATER, actions[0]);
            assertEquals(Action.DAY_EARLIER, actions[1]);
            assertEquals(Action.TIME_EARLIER, actions[2]);
            assertEquals(Action.DAY_LATER, actions[3]);
        } catch (IllegalArgumentException illegalArgumentException) {}
    }

}

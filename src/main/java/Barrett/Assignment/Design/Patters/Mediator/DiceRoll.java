package Barrett.Assignment.Design.Patters.Mediator;

import java.util.Random;

public class DiceRoll {

    public DiceRoll() {
    }

    public int rollD(int sides) {
        Random d = new Random();
        int result = d.nextInt(sides) + 1;
        return result;
    }

}

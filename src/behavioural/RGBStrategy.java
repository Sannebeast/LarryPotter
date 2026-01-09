package behavioural;

import characters.Student;
import game.HogwartsGame;

// Strategy pattern: defines a duel behavior that can be swapped with other strategies in the future

public class RGBStrategy implements DuelStrategy {
    // Defines the duel behavior between two wizards
    @Override
    public void duel(Student attacker, Student defender, String spellName) {
        String event =
                attacker.getName() +
                        " casts a colorful RGB " +
                        spellName +
                        " at " +
                        defender.getName() +
                        "!";

        // Notify observers instead of printing
        HogwartsGame.getInstance().notifyObservers(event);
    }
}

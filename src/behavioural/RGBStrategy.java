package behavioural;

import characters.Student;
import characters.LarryPotter;
import characters.SlytherinStudent;
import characters.GriffendorStudent;

// Strategy pattern: defines a duel behavior that can be swapped with other strategies in the future

public class RGBStrategy {
    // Defines the duel behavior between two wizards
    public void duel(characters.Student attacker, characters.Student defender) {
        System.out.println(attacker.getName() + " casts a colorful RGB spell at " + defender.getName() + "!");
    }
}

package characters;

import java.util.Random;

public class HufflepuffStudent extends Student {

    private Random rand = new Random();

    public HufflepuffStudent() {
        super("Hufflepuff Student");
    }

    @Override
    public void attack(Student opponent) {
        int damage = rand.nextInt(36); // 0-35 damage
        System.out.println(name + " casts a brave spell!");
        opponent.takeDamage(15);
    }
}

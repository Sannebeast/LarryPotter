package characters;

import java.util.Random;

public class SlytherinStudent extends Student {

    private Random rand = new Random();

    public SlytherinStudent() {
        super("Slytherin Student");
    }

    @Override
    public void attack(Student opponent) {
        int damage = 10 + rand.nextInt(16); // 10-25 damage
        System.out.println(name + " casts a sneaky curse!");
        opponent.takeDamage(damage);
    }
}

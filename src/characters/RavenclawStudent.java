package characters;

import java.util.Random;

public class RavenclawStudent extends Student {

    private Random rand = new Random();

    public RavenclawStudent() {
        super("RavenClaw Student");
    }

    @Override
    public void attack(Student opponent) {
        int damage = 20 + rand.nextInt(2); // 20-21 damage
        System.out.println(name + " casts a brave spell!");
        opponent.takeDamage(15);
    }
}

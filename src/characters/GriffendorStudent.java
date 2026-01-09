package characters;

import java.util.Random;

public class GriffendorStudent extends Student {

    private Random rand = new Random();

    public GriffendorStudent() {
        super("Gryffindor Student");
    }

    @Override
    public void attack(Student opponent) {
        int damage = 5 + rand.nextInt(26); // 5-30 damage
        System.out.println(name + " casts a brave spell!");
        opponent.takeDamage(15);
    }
}

package characters;

public class LarryPotter extends Student {

    public LarryPotter() {
        super("Larry Potter");
    }

    @Override
    public void attack(Student opponent) {
        opponent.takeDamage(15 + (int)(Math.random() * 11)); // 15-25 random damage
    }
}

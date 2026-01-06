package characters;

import behavioural.RGBStrategy;

public class LarryPotter extends Student {

    private RGBStrategy strategy;

    public LarryPotter() {
        super("Larry Potter");
        strategy = new RGBStrategy();
    }

    @Override
    public void attack(Student opponent) {
        strategy.duel(this, opponent);
        opponent.takeDamage(15 + (int)(Math.random() * 11)); // 15-25 random damage
    }
}

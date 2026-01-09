package characters;
import game.HogwartsGame;

public abstract class Student {
    protected String name;
    protected int health = 100;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;

        // Notify observers
        HogwartsGame.getInstance().notifyObservers(
                name + " took " + damage + " damage! HP: " + health
        );
    }

    public void heal(int amount) {
        health += amount;
        if (health > 100) health = 100;

        // Notify observers
        HogwartsGame.getInstance().notifyObservers(
                name + " healed " + amount + " HP. Current HP: " + health
        );
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void printHealthBar() {
        int bars = health / 10;
        System.out.print(name + " HP: [");
        for (int i = 0; i < bars; i++) System.out.print("|");
        for (int i = bars; i < 10; i++) System.out.print(" ");
        System.out.println("] " + health + "/100");
    }

    public abstract void attack(Student opponent);
}

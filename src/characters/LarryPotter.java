package characters;

public class LarryPotter extends Student {

    public LarryPotter() {
        super("Larry Potter");
    }

    @Override
    public void attack(Student opponent) {
        System.out.println(name + " casts Expelliarmus!");
        opponent.takeDamage(20);
    }
}

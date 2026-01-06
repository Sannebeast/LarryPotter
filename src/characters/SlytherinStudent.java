package characters;

public class SlytherinStudent extends Student {

    public SlytherinStudent() {
        super("Slytherin Student");
    }

    @Override
    public void attack(Student opponent) {
        System.out.println(name + " casts a sneaky curse!");
        opponent.takeDamage(18);
    }
}

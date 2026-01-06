public class GriffendorStudent extends Student {

    public GriffendorStudent() {
        super("Gryffindor Student");
    }

    @Override
    public void attack(Student opponent) {
        System.out.println(name + " casts a brave spell!");
        opponent.takeDamage(15);
    }
}

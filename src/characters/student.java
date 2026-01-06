public abstract class Student {
    protected String name;
    protected int health = 100;

    public Student(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. HP: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Student opponent);
}

package spells;

public class LoudSpellDecorator extends SpellDecorator {

    public LoudSpellDecorator(Spell spell) {
        super(spell);
    }

    @Override
    public void cast() {
        super.cast(); // call original spell
        System.out.println("✨ The spell echoes loudly!");
    }

    @Override
    public String getName() {
        return super.getName() + " (Loud)";
    }
}

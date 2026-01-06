package spells;

// Decorator pattern: allows enhancing any Spell object dynamically without changing its original code
public abstract class SpellDecorator implements Spell {

    protected Spell decoratedSpell;

    public SpellDecorator(Spell spell) {
        this.decoratedSpell = spell;
    }

    @Override
    public void cast() {
        decoratedSpell.cast();
    }

    @Override
    public String getName() {
        return decoratedSpell.getName();
    }
}

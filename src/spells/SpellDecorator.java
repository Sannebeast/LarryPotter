package spells;

public abstract class SpellDecorator implements Spell {

    protected Spell decoratedSpell;

    public SpellDecorator(Spell spell) {
        this.decoratedSpell = spell;
    }

    @Override
    public void cast() {
        decoratedSpell.cast(); // default behavior: delegate to the wrapped spell
    }

    @Override
    public String getName() {
        return decoratedSpell.getName(); // default: delegate to wrapped spell
    }
}

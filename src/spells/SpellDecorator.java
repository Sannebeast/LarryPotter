package spells;

import game.HogwartsGame;

// Decorator pattern: allows enhancing any Spell object dynamically without changing its original code
public abstract class SpellDecorator implements Spell {

    protected Spell decoratedSpell;

    public SpellDecorator(Spell spell) {
        this.decoratedSpell = spell;
    }

    @Override
    public void cast() {
        decoratedSpell.cast();

        // Notify observers
        HogwartsGame.getInstance().notifyObservers(
                decoratedSpell.getName() + " cast with decorator enhancement!"
        );
    }

    @Override
    public String getName() {
        return decoratedSpell.getName();
    }
}

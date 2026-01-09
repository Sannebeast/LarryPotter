package structural;

import game.HogwartsGame;
import spells.Spell;
// Adapter pattern: Allows AncientBook to be used for modern Spell interface

// Legacy spell class (old system)
class AncientBook {
    public void useSpell(String spellName) {

    }
}

// Adapter class
public class SpellAdapter implements Spell {

    private AncientBook ancientBook;
    private String spellName;

    public SpellAdapter(String spellName) {
        this.ancientBook = new AncientBook();
        this.spellName = spellName;
    }

    @Override
    public void cast() {
        ancientBook.useSpell(spellName);
        // Notify observers
        HogwartsGame.getInstance().notifyObservers(
                spellName + " was cast using AncientBook!"
        );
    }

    @Override
    public String getName() {
        return spellName;
    }
}

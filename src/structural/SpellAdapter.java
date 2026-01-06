package structural;

import spells.Spell;

// Legacy spell class (old system)
class AncientBook {
    public void useSpell(String spellName) {
        System.out.println("Ancient book casts: " + spellName);
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
    }

    @Override
    public String getName() {
        return spellName;
    }
}

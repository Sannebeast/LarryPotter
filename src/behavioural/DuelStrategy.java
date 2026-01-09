package behavioural;

import characters.Student;

public interface DuelStrategy {
    void duel(Student attacker, Student defender, String spellName);
}


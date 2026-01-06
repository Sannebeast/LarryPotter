import characters.*;
import factory.*;
import game.*;
import spells.Spell;
import structural.SpellAdapter;

public class Main {

    public static void main(String[] args) {

        HogwartsGame game = HogwartsGame.getInstance();
        game.startGame();

        Student player = StudentFactory.createStudent("LARRY");
        Student enemy = StudentFactory.createStudent("SLYTHERIN");

        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        game.endGame();
    }
}
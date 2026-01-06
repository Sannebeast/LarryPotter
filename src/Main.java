import characters.*;
import factory.StudentFactory;
import game.HogwartsGame;
import spells.Spell;
import spells.LoudSpellDecorator;
import structural.SpellAdapter;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HogwartsGame game = HogwartsGame.getInstance();
        game.startGame();

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Choose player
        System.out.println("Choose your student: LARRY, GRYFFINDOR, SLYTHERIN, RAVENCLAW, HUFFLEPUFF");
        String playerChoice = scanner.nextLine().toUpperCase();
        Student player = StudentFactory.createStudent(playerChoice);

        // Choose enemy
        System.out.println("Choose the enemy student: LARRY, GRYFFINDOR, SLYTHERIN, RAVENCLAW, HUFFLEPUFF");
        String enemyChoice = scanner.nextLine().toUpperCase();
        Student enemy = StudentFactory.createStudent(enemyChoice);

        // Create spells
        Spell fireball = new SpellAdapter("Fireball");            // Adapter
        Spell loudFireball = new LoudSpellDecorator(fireball);    // Decorator

        System.out.println("\nLet the duel begin!\n");

        // Duel loop
        while (player.isAlive() && enemy.isAlive()) {

            // Show health
            player.printHealthBar();
            enemy.printHealthBar();

            // Player turn
            System.out.println("\nYour turn! Choose an action:");
            System.out.println("1: Basic Attack");
            System.out.println("2: Cast Fireball");
            System.out.println("3: Cast Loud Fireball");
            System.out.println("4: Heal 10 HP");

            int action = scanner.nextInt();

            switch(action) {
                case 1 -> player.attack(enemy);
                case 2 -> {
                    fireball.cast();
                    enemy.takeDamage(15);
                }
                case 3 -> {
                    loudFireball.cast();
                    enemy.takeDamage(20);
                }
                case 4 -> player.heal(10);
                default -> System.out.println("Invalid action!");
            }

            if (!enemy.isAlive()) break;

            // Enemy turn
            System.out.println("\nEnemy's turn...");
            int enemyAction = rand.nextInt(3);
            // 0: attack, 1: fireball, 2: heal
            switch(enemyAction) {
                case 0 -> enemy.attack(player);
                case 1 -> {
                    fireball.cast();
                    player.takeDamage(20);
                }
                case 2 -> enemy.heal(10);
            }
        }

        // Game over
        System.out.println("\n--- Duel Over ---");
        if (!player.isAlive()) System.out.println("💀 You lost! Better luck next time.");
        else System.out.println("🏆 You won the duel!");

        // Replay option
        System.out.println("Play again? (yes/no)");
        scanner.nextLine();
        String again = scanner.nextLine();
        if (again.equalsIgnoreCase("yes")) main(null);
        else {
            game.endGame();
            scanner.close();
        }
    }
}

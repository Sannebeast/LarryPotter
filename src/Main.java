import characters.*;
import factory.StudentFactory;
import game.HogwartsGame;
import spells.Spell;
import spells.LoudSpellDecorator;
import structural.SpellAdapter;
import behavioural.GameEventObserver;
import behavioural.RGBStrategy;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HogwartsGame game = HogwartsGame.getInstance();
        game.setDuelStrategy(new RGBStrategy());
        game.startGame();

        // Add observer
        GameEventObserver ministry = new GameEventObserver("Ministry of Magic");
        game.addObserver(ministry);

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;

        while (playAgain) {

            // Choose player
            System.out.println("\nChoose your student: LARRY, GRYFFINDOR, SLYTHERIN, RAVENCLAW, HUFFLEPUFF");
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

                // Player turn
                System.out.println("\nYour turn! Choose an action:");
                System.out.println("1: Basic Attack");
                System.out.println("2: Cast Fireball");
                System.out.println("3: Cast Loud Fireball");
                System.out.println("4: Heal 10 HP");

                int action = -1;
                try {
                    action = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Try again.");
                    continue;
                }

                switch(action) {
                    case 1 -> {
                        player.attack(enemy);
                        game.performDuel(player, enemy, "Basic attack");
                        printHealth(player, enemy);
                    }
                    case 2 -> {
                        fireball.cast();
                        game.performDuel(player, enemy, "Fireball");
                        enemy.takeDamage(15);
                        printHealth(player, enemy);
                    }
                    case 3 -> {
                        loudFireball.cast();
                        game.performDuel(player, enemy, "Loud Fireball");
                        enemy.takeDamage(20);
                        printHealth(player, enemy);
                    }
                    case 4 -> {
                        player.heal(10);
                        printHealth(player, enemy);
                    }
                    default -> System.out.println("Invalid action! Choose 1-4.");
                }

                if (!enemy.isAlive()) break;

                // Enemy turn
                System.out.println("\nEnemy's turn...");
                int enemyAction = rand.nextInt(3); // 0: attack, 1: fireball, 2: heal
                switch(enemyAction) {
                    case 0 -> {
                        enemy.attack(player);
                        game.performDuel(player, enemy, "Basic attack");
                        printHealth(player, enemy);
                    }
                    case 1 -> {
                        fireball.cast();
                        game.performDuel(player, enemy, "Fireball");
                        player.takeDamage(20);
                        printHealth(player, enemy);
                    }
                    case 2 -> {
                        enemy.heal(10);
                        printHealth(player, enemy);
                    }
                }
            }

            // Game over
            System.out.println("\n--- Duel Over ---");
            if (!player.isAlive()) System.out.println("💀 You lost! Better luck next time.");
            else System.out.println("🏆 You won the duel!");

            // Replay option
            System.out.println("Play again? (yes/no)");
            String again = scanner.nextLine().trim();
            playAgain = again.equalsIgnoreCase("yes");
        }

        // End game
        game.endGame();
        scanner.close();
    }

    // Helper method to print health bars cleanly
    private static void printHealth(Student player, Student enemy) {
        System.out.println();
        player.printHealthBar();
        enemy.printHealthBar();
        System.out.println();
    }
}

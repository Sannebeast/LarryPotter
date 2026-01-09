package game;

import behavioural.GameEventObserver;
import behavioural.DuelStrategy;
import characters.Student;
import java.util.ArrayList;
import java.util.List;

public class HogwartsGame {

    private static HogwartsGame instance;
    private DuelStrategy duelStrategy;
    private List<GameEventObserver> observers = new ArrayList<>();

    private HogwartsGame() {}

    public static HogwartsGame getInstance() {
        if (instance == null) {
            instance = new HogwartsGame();
        }
        return instance;
    }

    // Start / end game
    public void startGame() {
        System.out.println("🏰 Welcome to Hogwarts Duel!");
    }

    public void endGame() {
        System.out.println("✨ Game over!");
    }

    // Add observer
    public void addObserver(GameEventObserver observer) {
        observers.add(observer);
    }

    // Notify observer about an event
    public void notifyObservers(String event) {
        for (GameEventObserver observer : observers) {
            observer.notify(event);
        }
    }

    // Setting strategy
    public void setDuelStrategy(DuelStrategy duelStrategy) {
        this.duelStrategy = duelStrategy;
    }

    // Checking if there is a strategy and then calling duel
    public void performDuel(Student attacker, Student defender, String spellName) {
        if (duelStrategy != null) {
            duelStrategy.duel(attacker, defender, spellName);
        }
    }
}
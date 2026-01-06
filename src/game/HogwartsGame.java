package game;

import behavioural.GameEventObserver;
import java.util.ArrayList;
import java.util.List;

public class HogwartsGame {

    private static HogwartsGame instance;

    // List of observers
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

    // Remove observer
    public void removeObserver(GameEventObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about an event
    public void notifyObservers(String event) {
        for (GameEventObserver observer : observers) {
            observer.notify(event);
        }
    }
}
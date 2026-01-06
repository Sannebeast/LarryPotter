package game;

public class HogwartsGame {

    private static HogwartsGame instance;

    private HogwartsGame() {}

    public static HogwartsGame getInstance() {
        if (instance == null) {
            instance = new HogwartsGame();
        }
        return instance;
    }

    public void startGame() {
        System.out.println("🏰 Welcome to Hogwarts Duel!");
    }

    public void endGame() {
        System.out.println("✨ Game over!");
    }
}
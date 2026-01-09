package behavioural;

/*
 * Observer pattern: reacts to game events in real-time
 * Example: Ministry of Magic observes duels, spells, and damage
 */
public class GameEventObserver {

    private String observerName;

    public GameEventObserver(String name) {
        this.observerName = name;
    }

    // This is called whenever an event occurs
    public void notify(String event) {
        System.out.println(observerName + " observed: " + event);
    }
}

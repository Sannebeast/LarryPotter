# Hogwarts RPG Game (Console-Based)

## Project Idea
Make a Harry Potter related game that allows students from different houses fight against each other.

---

## Team Members & Cooperation

**Student A:**  
- Name: *[Naïmi de Jong]*  
- Responsibilities:
  - Singleton pattern (`HogwartsGame`)
  - Factory pattern (`StudentFactory`)
  - Characters (`GriffendorStudent`, `LarryPotter`, `SlytherinStudent`)

**Student B:** 
- Name: *[Sanne Jimkes]*  
- Responsibilities:
  - Strategy pattern (`RGBStrategy`)
  - Observer pattern (Ministry of Magic observers)
  - Decorator pattern (spell enhancements)
  - Adapter pattern (spell sound integration)

The project is developed collaboratively.  
Responsibilities are divided by design pattern groups to ensure balanced contributions.

---

## Planned Project Structure
```
src/
├── behavioural/
│   ├── GameEventObserver.java        (Observer)
│   └── RGBStrategy.java              (Strategy)
├── characters/
│   ├── GriffendorStudent.java
│   ├── LarryPotter.java
│   └── SlytherinStudent.java      
├── factory/
│   └── StudentFactory.java           (Factory)
├── game/
│   └── HogwartsGame.java             (Singleton)
├── spells/
│   ├── Spell.java
│   └── SpellDecorator.java           (Decorator)
├── structural/
│   └── SpellAdapter.java             (Adapter)
└── Main.java
```

---

## Design Principles & Patterns

The following design patterns are planned for this project. They were chosen to keep the game modular, extensible, and easy to maintain while supporting future expansion.

### Creational Patterns

**Singleton**  
Ensures that only one instance of the game controller exists during runtime.  
In our game, this pattern is used for the main game class (`HogwartsGame`) which manages the game flow and overall state.  
This was chosen to avoid multiple game instances running at the same time and to provide a single point of control.

**Factory**  
Encapsulates object creation and hides concrete class instantiation from the client.  
In our game, the `StudentFactory` will be responsible for creating different wizard types (e.g., student wizard, dark wizard).  
This was chosen to simplify wizard creation and allow new wizard types to be added without modifying existing game logic.

---

### Structural Patterns

**Decorator**  
Allows behavior to be added dynamically to objects without altering their original structure.  
In our game, spells can be enhanced with additional effects (such as increased power or sound effects) using decorators.  
This was chosen to avoid creating many subclasses for every possible spell variation.

**Adapter**  
Converts the interface of a class into another interface that the client expects.
In our game, the SpellBookAdapter allows legacy spells from an old spell book (which uses a useSpell() method) to be used as regular spells through the Spell interface (cast()).
This was chosen to integrate legacy or external spell systems without modifying existing code and to keep the modern spell system consistent.

---

### Behavioural Patterns

**Strategy**  
Defines a family of algorithms and makes them interchangeable at runtime.  
In our game, different duel strategies can be selected dynamically, allowing wizards to duel in different ways without changing their classes.  
This was chosen to make duel behavior flexible and easily extendable.

**Observer**  
Defines a one-to-many dependency where observers are notified automatically when a subject changes state.  
In our game, important events (such as duels or spell usage) will notify observers like the Ministry of Magic.  
This was chosen to decouple game events from the systems that react to them.


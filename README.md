## LDTS_t13g05 - Diamond Maze

> A knight finds himself lost in a labyrinth that seems to have no end. He needs to find the secret key to escape through the gate.

> ⁠The time limit must be taken into account. Scattered throughout the map, there are items that increase this time limit. If the player fails to open the portal within the time limit, the level restarts.
⁠To achieve a higher score, the player needs to collect the diamonds randomly distributed throughout the map.
To capture the key, the player must discover which of the diamonds holds the key.
⁠To make the game more difficult, there are guards scattered throughout the map. If an guard catches the player, the level restarts.

> 	⁠This project was developed by *Ricardo Estevéns* ([up202405321@up.pt](mailto:up202405321@up.pt)), *Gustavo Oliveira* ([up202205770@up.pt](mailto:up202205770@up.pt)), and *Rogério Barbosa* ([up202406902@up.pt](mailto:up202406902@up.pt)) for LDTS 2025/26.


### IMPLEMENTED FEATURES

- *Knight* - The game's character.
- *Guards* - Scattered throughout the map.
- *Time* - There is a timer to complete the level.
- *Score* - Determines the stars after completing the level.
- *Key* - It will be hidden in a diamond. It is used to open the portal.
- *Diamonds* - Located in the map, gives a random score.
- *Potions* - Give a random positive or negative effect to the game for a limited period (Guards or Knight visual disappearing, time increase or decrease, Guards or Knight speed change).
- ⁠*Door* - Allows you to proceed to the next level.
- ⁠*Walls* - Limits the movement area within the map.
- ⁠*Movement* - Using the arrow keys or WASD (up, down, left, and right).
<br>

- *Main Menu*
<img width="1920" height="1080" alt="Mockup 1" src="https://github.com/user-attachments/assets/7014a8d5-6595-46a5-a0de-a0afa41dbfac" />

- *Controls Menu*
<img width="1920" height="1080" alt="Mockup 2" src="https://github.com/user-attachments/assets/36320354-047e-4ef3-a3a9-40d45b070e22" />

- *Levels Menu*
<img width="1920" height="1080" alt="Mockup 3" src="https://github.com/user-attachments/assets/bdf7c848-be01-485a-aa79-6e28f66ffb66" />

- *Level 1*
<img width="1920" height="1080" alt="Captura de ecrã de 2025-12-30 19-14-50" src="https://github.com/user-attachments/assets/13a55767-1e97-458c-86fe-a2792da23f4a" />

- *Level 2*
<img width="1920" height="1080" alt="Captura de ecrã de 2025-12-30 19-29-21" src="https://github.com/user-attachments/assets/7a309308-5125-40e8-886b-60421b7d1197" />

- *Level 3*
<img width="1920" height="1080" alt="Captura de ecrã de 2025-12-30 19-30-47" src="https://github.com/user-attachments/assets/2757ff25-1305-4a86-94a3-18731c4d2330" />

- *Level Passed*
<img width="1920" height="1080" alt="Captura de ecrã de 2025-12-30 19-35-41" src="https://github.com/user-attachments/assets/c953047a-2649-47ad-979b-5680df180eaa" />

- *Game Over*
<img width="1920" height="1080" alt="Captura de ecrã de 2025-12-30 19-32-08" src="https://github.com/user-attachments/assets/ea131302-4186-48bf-b102-b7a58635052a" />


### PLANNED FEATURES

- ⁠*Unveiling the map* - The player will have to walk around the map to reveal it.

### DESIGN

<img width="8175" height="5557" alt="UML" src="https://github.com/user-attachments/assets/eac794ac-90ff-4a01-b107-e89e6ed4ba28" />

*Problem in Context.*

To improve code organization, we needed a design approach that would allow us to implement a better *separation of concerns* for each game object. The core problem was the *excessive interdependence* between the game's logic, visual presentation, and user input handling.

*The Pattern*

We implemented the *MVC (Model-View-Controller) Architectural Pattern*. This pattern organizes the code into three distinct components:

- ⁠*Model*: Responsible for the entities in the game, such as MenuMain, MenuLevels, and the Maze for each level.
- ⁠*View*: Handles rendering the current state of the game—for example, MazeViewer draws the maze for each level, and MenuMainViewer renders the main menu.
- ⁠*Controller*: Manages state transitions based on user input and updates the Model accordingly, as seen in KnightController, which controls the knight’s movement within the maze.

This structure ensures a clear separation of concerns, improving both maintainability and scalability.

*Implementation*

UML reprensentation showing above.

*Consequences.* 

Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

- *Enhanced Maintainability:* Changes to the GUI can be made without touching the game logic (Model). For instance, changing the knight's sprite is now isolated to the ⁠ KnightViewer ⁠ class.
- ⁠*Improved Testability:* The Model can be tested in isolation with unit tests, as it has no dependencies on the View or Controller. For example, we can write tests for ⁠ knight.move() ⁠ without testing into the game.
- ⁠*Parallel Development:* The clear boundaries allow one developer to work on the ⁠ Maze ⁠ logic (Model) while another works on the ⁠ MazeViewer ⁠ (View), with minimal conflict.
- ⁠*Clarity and Structure:* The code is now organized according to a well-known pattern, making it instantly more understandable to new developers joining the project.

*Problem in Context.*

The game currently uses extensive conditional logic within different Game objects:

The menu navigation relies on numerous conditional statements to determine which button is selected and what happens when buttons are pressed. 

For the state of Maze we need an approach to control the flow of the Game, for Characters and Elements.

*The Pattern*

We implemented the *State Pattern* to encapsulate state-specific behavior into dedicated classes. This pattern provides a structured approach to managing state-dependent behavior.

State changes become clear, explicit operations rather than implicit side effects of conditional logic.

New states can be added without modifying existing state logic, following the Open/Closed Principle.

*Implementation*

[GameState] [https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/state/GameState.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/GameState.java)

[MenuLevelsState] [https://github.com/FEUP-LDTS 2025/projectt13g05/blob/main/src/main/java/org/example/state/MenuLevelsState.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuLevelsState.java)

[MenuMainState] https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuMainState.java

[State] [https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/State.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuMainState.java)

*Consequences.* 

The use of the State Pattern in the current design allows the following benefits:

- ⁠*Improve Code Readability:* The several states that represent the Maze changes with different stages of the Game become more explicit in the code.
- ⁠*State Management:* The implementation now involves a greater number of classes and instances, but this added structure *significantly simplifies overall management and scalability*.

*Problem in Context.*

To address the complexity inherent in Maze implementations containing numerous diverse components, a approach was required to enable more organized and maintainable Maze creation.

*The Pattern*

We implemented the *Builder Pattern.* It’s primarily used to address challenges related to *creating complex objects* that have numerous parameters, particularly when many of these parameters are optional or require step-by-step construction.

*Implementation*

[LoaderMazeBuilder]
[https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java](https://github.com/FEUP-LDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java)

[MazeBuilder]
[https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/MazeBuilder.java](https://github.com/FEUP-LDTS-2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java)

*Consequences.* 

The use of the *Builder Pattern* in the current Maze design allows for the following key benefits:

- *Encapsulated Construction Logic:* It encapsulates the complex algorithm for creating a maze (like generating guards, knight and elements). The client code doesn't need to know how a maze is assembled, it only specifies what it wants.
- ⁠*Step-by-Step Construction:* It allows the maze to be constructed step-by-step. The ⁠ MazeBuilder ⁠ can first create Maze and ⁠ LoaderMazeBuilder ⁠ populate the ⁠ Maze ⁠ with characters and elements, all within a single controlled process.
- ⁠*Validation and Consistency:* This ensures that every ⁠ Maze ⁠ object is in a consistent and valid state upon creation.
- ⁠*Separation of Concerns:* It separates the code for constructing a maze from the ⁠ Maze ⁠ class itself. The ⁠ Maze ⁠ class can remain focused on its core responsibility representing the maze structure and providing an interface for navigation and interaction.

#### KNOWN CODE SMELLS

- *Duplicate Code & Resource Inefficiency*: The project initially contained redundant logic for loading resources, specifically within the *Image* and *Wall* classes. The font file was being read from the disk for every single entity instantiation rather than being cached. This caused severe performance bottlenecks during level transitions.

- *Magic Numbers*: The codebase relies heavily on hardcoded numeric literals to define UI layouts, sprite dimensions (e.g., resizing images to 25x25 or 40x40), and specific screen coordinates in menus. The lack of context of those values, made the *UI* difficult to adjust or maintain without breaking the layout.

- *High Coupling*: There was a tight coupling between the *Image* viewer class and the *LanternaGUI* implementation. The domain objects were directly dependent on the specific *GUI* implementation to fetch font resources, violating the principle of Separation of Concerns and making the code harder to test in isolation.

- *Temporary Fields*: In the *Image* class, the font field was being initialized in the constructor but was never actually used by the object's instance methods, serving only as unnecessary overhead.
    
### TESTING

*Coverage Report*
<img width="1600" height="625" alt="Coverage" src="https://github.com/user-attachments/assets/067b441b-81d1-409a-af06-3b4dc587827e" />

*Pitest Report*
<img width="1512" height="815" alt="Pitest" src="https://github.com/user-attachments/assets/c865dca6-587a-49c2-bb87-1774eb325e98" />

### SELF-EVALUATION

- ⁠Gustavo Oliveira: 33%
- ⁠Ricardo Estevéns: 33%
- ⁠Rogério Barbosa: 34%

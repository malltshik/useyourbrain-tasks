package ru.malltshik.tasks.games.game2048;

import ru.malltshik.tasks.games.exceptions.GameOverException;
import ru.malltshik.tasks.games.game2048.models.Field;
import ru.malltshik.tasks.games.game2048.models.Window;


// TODO refactorings algorithms (less time & ram complexity)
// TODO set comments for the classes and methods
// TODO clean up 
public class Game {

    public static void main(String[] args) throws GameOverException {
        Field field = new Field();
        Window window = new Window(field);
        window.show();
    }

}

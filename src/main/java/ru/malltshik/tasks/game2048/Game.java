package ru.malltshik.tasks.game2048;

import ru.malltshik.tasks.game2048.exceptions.GameOverException;
import ru.malltshik.tasks.game2048.models.Field;
import ru.malltshik.tasks.game2048.models.Window;

public class Game {

    public static void main(String[] args) throws GameOverException {
        Field field = new Field();
        Window window = new Window(field);
        window.show();
    }

}

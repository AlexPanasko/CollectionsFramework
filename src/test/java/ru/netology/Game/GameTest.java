package ru.netology.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player pasha = new Player(1, "Паша", 200);
        Player sasha = new Player(2, "Саша", 250);
        Game game = new Game();

        game.register(pasha);
        game.register(sasha);
        int actual = game.round("Саша", "Паша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player pasha = new Player(1, "Паша", 220);
        Player sasha = new Player(2, "Саша", 200);
        Game game = new Game();

        game.register(pasha);
        game.register(sasha);
        int actual = game.round("Саша", "Паша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player pasha = new Player(1, "Паша", 200);
        Player sasha = new Player(2, "Саша", 200);
        Game game = new Game();

        game.register(pasha);
        game.register(sasha);
        int actual = game.round("Саша", "Паша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player pasha = new Player(1, "Паша", 200);
        Player sasha = new Player(1, "Саша", 250);
        Game game = new Game();

        game.register(pasha);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Паша")
                );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player pasha = new Player(1, "Паша", 200);
        Player sasha = new Player(1, "Саша", 250);
        Game game = new Game();

        game.register(pasha);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Коля")
        );
    }
}

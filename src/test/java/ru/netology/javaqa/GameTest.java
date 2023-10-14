package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void shouldFirstPlayer1More() {
        Player alex = new Player(1, "Александр", 150);
        Player tony = new Player(2, "Антон", 140);
        Game game = new Game();

        game.register(alex);
        game.register(tony);

        int actual = game.round("Александр", "Антон");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFirstPlayer2More() {
        Player alex = new Player(1, "Александр", 150);
        Player tony = new Player(2, "Антон", 165);
        Game game = new Game();

        game.register(alex);
        game.register(tony);

        int actual = game.round("Александр", "Антон");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFirstPlayer2Equal() {
        Player alex = new Player(1, "Александр", 134);
        Player tony = new Player(2, "Антон", 134);
        Game game = new Game();

        game.register(alex);
        game.register(tony);

        int actual = game.round("Александр", "Антон");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFirstPlayer1NotRegistered() {
        Player alex = new Player(1, "Александр", 134);
        Player tony = new Player(2, "Антон", 134);
        Game game = new Game();

        game.register(alex);
        game.register(tony);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Виталий", "Антон"));

    }

    @Test
    public void shouldFirstPlayer2NotRegistered() {
        Player alex = new Player(1, "Александр", 134);
        Player tony = new Player(2, "Антон", 134);
        Game game = new Game();

        game.register(alex);
        game.register(tony);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Александр", "Сергей"));

    }
}
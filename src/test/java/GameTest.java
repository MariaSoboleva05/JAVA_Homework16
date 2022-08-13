import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game regPlayers = new Game();

    Player player1 = new Player(1, "Sasha", 25);
    Player player2 = new Player(2, "Kolya", 14);
    Player player3 = new Player(3, "Olya", 19);
    Player player4 = new Player(4, "Slava", 11);
    Player player5 = new Player(5, "Igor", 14);

    @Test
    public void shouldCompareStrengthIfEqual() {
        regPlayers.register(player2);
        regPlayers.register(player5);

        int expected = 0;
        int actual = regPlayers.round("Kolya", "Igor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthIfFirstPlayerAreStronger() {
        regPlayers.register(player1);
        regPlayers.register(player3);

        int expected = 1;
        int actual = regPlayers.round("Sasha", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthIfSecondPlayerAreStronger() {
        regPlayers.register(player4);
        regPlayers.register(player3);

        int expected = 2;
        int actual = regPlayers.round("Slava", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthIfFirstPlayerAreNotRegistered() {
        regPlayers.register(player4);
        regPlayers.register(player3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            regPlayers.round("Sasha", "Olya");
        });
    }

    @Test
    public void shouldCompareStrengthIfSecondPlayerAreNotRegistered() {
        regPlayers.register(player2);
        regPlayers.register(player5);

        Assertions.assertThrows(RuntimeException.class, () -> {
            regPlayers.round("Kolya", "Olya");
        });
    }

    @Test
    public void shouldCompareStrengthIfBothPlayersAreNotRegistered() {
        regPlayers.register(player2);
        regPlayers.register(player5);

        Assertions.assertThrows(RuntimeException.class, () -> {
            regPlayers.round("Sasha", "Slava");
        });
    }
}

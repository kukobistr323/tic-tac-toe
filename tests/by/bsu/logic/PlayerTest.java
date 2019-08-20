package by.bsu.logic;

import by.bsu.exceptions.BusyCellException;
import by.bsu.exceptions.WrongInputException;
import org.junit.Before;

import org.junit.*;

import static by.bsu.logic.Game.FIELD_SIZE;

public class PlayerTest {

    private Player player;
    private Game game;

    @Before
    public void before() {
        game = new Game();
        player = new Player(game);
    }

    @Test
    public void putSymbOnCenter() throws WrongInputException, BusyCellException {
        player.step("5");
        Assert.assertEquals(game.getField()[1][1],State.X);
    }

    @Test(expected = WrongInputException.class)
    public void putWrontInput() throws WrongInputException, BusyCellException {
        player.step("12");
    }

    @Test(expected = BusyCellException.class)
    public void putInBusyCell() throws WrongInputException, BusyCellException {
        player.step("5");
        player.step("5");
    }

}
package by.bsu.logic;



import static by.bsu.logic.Game.FIELD_SIZE;
import org.junit.*;

public class CheckerTest {

    private Checker checker;
    private Game game;

    @Before
    public void before() {
        game = new Game();
        checker = new Checker(game);
    }

    @Test
    public void checkLeftDiagonal() {
        Enum<State> field[][] = new Enum[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i][i] = State.X;
        }
        game.setField(field);
        Assert.assertTrue(checker.isWin());
    }

    @Test
    public void checkRightDiagonal() {
        Enum<State> field[][] = new Enum[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[FIELD_SIZE - i - 1][i] = State.O;
        }
        game.setField(field);
        Assert.assertTrue(checker.isWin());
    }

    @Test
    public void checkHorizontal() {
        Enum<State> field[][] = new Enum[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[0][i] = State.O;
        }
        game.setField(field);
        Assert.assertTrue(checker.isWin());
    }

    @Test
    public void checkVertical() {
        Enum<State> field[][] = new Enum[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i][0] = State.O;
        }
        game.setField(field);
        Assert.assertTrue(checker.isWin());
    }

    @Test
    public void checkDraw() {
        game.setSteps(10);
        Assert.assertTrue(checker.isDraw());
    }
}
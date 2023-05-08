import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class GameStateTest {

    GameState gameStateTest = new GameState();
    @Test
    public void isValidMoveTest(){
        assertEquals(false, gameStateTest.isValidMove(10));
    }

    @Test
    public void calculateGameStateTest(){

        Board boardTest = new Board();
        boardTest.makeBoard();
        assertEquals(gameStateTest.gameState.IN_PROGRESS, gameStateTest.calulateGameState(boardTest.getBoard(), "X"));
    }

    @Test
    public void getPlayerStatsMock(){
        LoadFile loadFileMock = spy(LoadFile.class);
        List<String> data = new ArrayList<>();
        data.add("Derek,5");
        when(loadFileMock.getFileData("Scores.txt")).thenReturn(data);
        assertEquals("Derek,5", gameStateTest.getPlayerStats(loadFileMock.getFileData("Scores.txt"), "Derek"));
    }

    @Test
    public void getPlayerStatStub(){
        List<String> data = new ArrayList<>();
        data.add("Derek,5");
        data.add("Darren,4");
        assertEquals("Darren,4", gameStateTest.getPlayerStats(data, "Darren"));

    }
}
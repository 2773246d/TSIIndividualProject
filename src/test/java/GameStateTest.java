import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    /*@Test
    public void updateLeaderBoardTest(){
        gameStateTest.updateLeaderBoard("Derek");
    }*/
}
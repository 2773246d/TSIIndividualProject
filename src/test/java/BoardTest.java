import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class BoardTest {

    Board boardTest = new Board();

    @Test
    public void getBoardRowTest() {
        boardTest.makeBoard();
        String testBoardRow = "|   |   |   | ";
        assertEquals(testBoardRow, boardTest.getBoardRow(0));
    }

    @Test
    public void getBoardRowTestMock() {
        Board mockBoard = spy(Board.class);
        boardTest.makeBoard();
        when(mockBoard.getBoardRow(0)).thenReturn("|   |   |   | ");
        assertEquals("|   |   |   | ", boardTest.getBoardRow(0));
    }

    @Test
    public void isBoardFullTest() {
        boardTest.makeBoard();
        assertEquals(false, boardTest.isBoardFull());
    }

    @Test

    public void insertIntoBoardTest() {
        boardTest.makeBoard();
        boardTest.insertIntoBoard(1, "X");
        assertEquals("| X |   |   | ", boardTest.getBoardRow(0));

    }
}


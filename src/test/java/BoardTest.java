import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {

    Board boardTest = new Board();

    @Test
    public void getBoardRowTest() {
        boardTest.makeBoard();
        String testBoardRow = "|   |   |   | ";
        assertEquals(testBoardRow, boardTest.getBoardRow(0));
    }
    @Test
    public void isBoardFullTestTrue(){
        boardTest.makeBoard();
        for(int i=1;i<10;i++){
            boardTest.insertIntoBoard(i, "X");
        }
        assertEquals(true, boardTest.isBoardFull());
    }

    @Test
    public void isBoardFullTestFalse() {
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


import java.util.Random;

public class Board {

    private String[][] board= new String[3][3];

    public String[][] getBoard() {
        return board;
    }

    public String[][] makeBoard() {
        int num = 1;
        for (int x = 0; x < this.board.length; x++){
            for(int y=0;y<this.board.length;y++){
                this.board[x][y] = " ";
            }
        }
        return this.board;
    }

    public void displayBoard(){
        System.out.println("| - | - | - |");
        System.out.println(this.getBoardRow(0));
        System.out.println("| - | - | - |");
        System.out.println(this.getBoardRow(1));
        System.out.println("| - | - | - |");
        System.out.println(this.getBoardRow(2));
        System.out.println("| - | - | - |");
    }
    public String getBoardRow(int row) {
        String boardRow = "| ";
        for (int x = 0; x < this.board.length; x++) {
            if (x == row) {
                for (int y = 0; y < this.board.length; y++) {
                    boardRow += this.board[x][y] + " | ";
                }
            }
        }
        return boardRow;
    }
    public void displayInstructionBoard(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }


    public void insertIntoBoard(int position, String piece) {
        int row = (position - 1) / 3;
        int col = (position - (row * 3)) - 1;
        if (this.board[row][col].equals(" ")) {
            if (piece.equals("X")) board[row][col] = "X";
            if (piece.equals("O")) board[row][col] = "O";
        }
    }
    public boolean isBoardFull(){
        int count = 0;
        for (int x = 0; x < this.board.length; x++){
            for(int y=0;y<this.board.length;y++){
                if(this.board[x][y] == " "){
                    count++;
                }
            }
        }
        return count>0?false:true;

    }

    public void computerPlay(String piece){
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        boolean piecePLayed = false;

        while(!piecePLayed && !isBoardFull()){
            if(board[row][col] == " "){
                piecePLayed = true;
                if (piece.equals("X")) board[row][col] = "X";
                if (piece.equals("O")) board[row][col] = "O";

            }else{
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
        }
    }




}

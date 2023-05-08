import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.getBoard());
        GameState gameState = new GameState();
        Load loadFile = new LoadFile();
        board.displayInstructionBoard();
        board.makeBoard();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String username = userInput.nextLine();

        while(gameState.gameState== GameState.State.IN_PROGRESS && !board.isBoardFull()){
            board.displayBoard();
            System.out.println("Please enter a position");
            int position = Integer.parseInt(userInput.nextLine());
            board.insertIntoBoard(position, "X");
            if(gameState.calulateGameState(board.getBoard(), "X")== GameState.State.X_WON){
                System.out.println("X Won");
                gameState.gameState = GameState.State.X_WON;
                board.displayBoard();
                gameState.updateLeaderBoard(username);
            }
            board.computerPlay("O");
            if(gameState.calulateGameState(board.getBoard(), "O")== GameState.State.O_WON) {
                System.out.println("O Won");
                gameState.gameState = GameState.State.X_WON;
                board.displayBoard();
            }

        }
        System.out.println(gameState.getPlayerStats(loadFile.getFileData("Scores.txt"), username));



}
}
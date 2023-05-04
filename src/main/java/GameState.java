import java.util.ArrayList;
import java.util.List;

public class GameState {

    public State gameState = State.IN_PROGRESS;
    public List<int[][]> winMoveCoord(){
        int[][] topRow = {{0,0},{0,1},{0,2}};
        int[][] middleRow = {{1,0},{1,1},{1,2}};
        int[][] bottomRow = {{2,0}, {2,1}, {2,2}};

        int[][] leftColumn = {{0,0},{1,0},{2,0}};
        int[][] middleColumn = {{0,1}, {1,1}, {2,1}};
        int[][] lastColumn = {{0,2}, {1,2}, {2,2}};

        int[][] diagonalRight = {{0,0}, {1,1}, {2,2}};
        int[][] diagonalLeft = {{0,2}, {1,1}, {2,0}};
        List<int[][]> winningPositions = new ArrayList<int[][]>();
        winningPositions.add(topRow);
        winningPositions.add(middleRow);
        winningPositions.add(bottomRow);

        winningPositions.add(leftColumn);
        winningPositions.add(middleColumn);
        winningPositions.add(lastColumn);

        winningPositions.add(diagonalRight);
        winningPositions.add(diagonalLeft);
        return winningPositions;
    }
    public boolean isValidMove(int move){
        if(move<0 || move>9){
            return false;
        }
        else{
            return true;
        }
    }
    public State calulateGameState(String[][] board, String player){
        for(int[][] position : this.winMoveCoord()){
            if(board[position[0][0]][position[0][1]].equals(player) && board[position[1][0]][position[1][1]].equals(player) && board[position[2][0]][position[2][1]].equals(player)){
                return player=="X"?gameState.X_WON:gameState.O_WON;
            }

        }
        return gameState.IN_PROGRESS;
    }
    public void updateLeaderBoard(String username){
        WriteFile writer = new WriteFile();
        List<String> fileData = new ArrayList<>();
        LoadFile loader = new LoadFile();

        fileData = loader.getFileData("Scores.txt");
        for(int line=0; line< fileData.size();line++){
            if(username.equals(fileData.get(line).split(",")[0])){
                int score = Integer.parseInt(fileData.get(line).split(",")[1]);
                score++;
                fileData.set(line, username + "," + score);
                writer.writeToFile("Scores.txt", fileData);
                return;
            }

        }
        fileData.add(username + "," + 1);

        writer.writeToFile("Scores.txt", fileData);
    }



    public enum State{
        IN_PROGRESS,X_WON,O_WON,DRAW;
    }



}

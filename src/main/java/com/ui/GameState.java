package ui;

import logic.DrawerBoard;
import logic.GameResultChecker;
import logic.GameStats;
import logic.Player;

public class GameState {
     private Player currentPlayer;

     private final Player[][] playersMoves;

     private GameStats gameStats;

    public GameStats getGameStats() {
        return gameStats;
    }

    public GameState(){
        currentPlayer = Player.X;
        playersMoves = new Player[3][3];
        gameStats = new GameStats();
    }

    public void addMove(int row, int column){
        playersMoves[row][column] = currentPlayer;

        //System.out.print(currentPlayer + "_");
        //isRoundWon();
        /*
        if(isRoundWon()){
            //System.out.println( "\n" + currentPlayer + " wins");
            DrawerBoard.drawBoard(playersMoves, gameStats);
        }*/
    }

    public Player getCurrentPLayer() {
        return currentPlayer;
    }

    public boolean isRoundWon() {
        return GameResultChecker.checkWinner(playersMoves, currentPlayer);

    }
    public void updateStats() {
        if(isRoundWon() && currentPlayer == Player.X) {
            gameStats.setX_wins(gameStats.getX_wins() + 1);
        }
        if(isRoundWon() && currentPlayer == Player.O){
            gameStats.setO_wins(gameStats.getO_wins()+1);
        }
    }

    public void changePlayer(){
        if(currentPlayer == Player.X){
            currentPlayer = Player.O;
        }else{
            currentPlayer = Player.X;
        }
    }

    public Player[][] getPlayersMoves() {
        return playersMoves;
    }

    public void restart(){

        //restart the moves
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                playersMoves[i][j] = null;
            }
        }

        //restart the current move
        currentPlayer = Player.X;
    }

    public boolean isBoardFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(playersMoves[i][j]==null)
                    return false;
            }
        }
        return true;
    }
}

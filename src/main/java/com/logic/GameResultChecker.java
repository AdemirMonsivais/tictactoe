package logic;
//import utils.PlayerMode;
public final class GameResultChecker {
    public static boolean checkWinner(Player[][] playersMoves, Player currentPlayer){
        for(int i = 0; i < 3; i++){
            if((playersMoves[i][0] == currentPlayer && playersMoves[i][1] == currentPlayer && playersMoves[i][2] == currentPlayer) || //check rows
                    (playersMoves[0][i] == currentPlayer && playersMoves[1][i] == currentPlayer && playersMoves[2][i] == currentPlayer)) {//check columns
                return true;
            }
        }

        //Check Diagonals
        return ((playersMoves[0][0] == currentPlayer && playersMoves[1][1] == currentPlayer && playersMoves[2][2] == currentPlayer)||
                (playersMoves[2][0] == currentPlayer && playersMoves[1][1] == currentPlayer && playersMoves[0][2] == currentPlayer));
    }


}

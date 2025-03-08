package logic;

public class DrawerBoard {

    public static void drawBoard(Player[][] playersMoves, GameStats gameStats){
        //format thw board
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                    System.out.print(" " +  ((playersMoves[i][j] == null)? " " : playersMoves[i][j]));
                if(j < 2){
                    System.out.print(" |");
                }
            }

            if(i < 2){
                System.out.println("\n_ _ _ _ _ _");
            }else {
                //System.out.printf("\n\nWins: %d Ties: %d Losses: %d\n\n",gameStats.getWins(), gameStats.getTies(), gameStats.getLosses());
            }

        }
    }

}

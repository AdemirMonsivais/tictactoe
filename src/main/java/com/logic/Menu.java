package logic;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private static void clearConsole(){//doesn't clear the console
       for (int i = 0; i < 50; i++) {
           System.out.println();
       }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        Player[][] playersMoves = new Player[3][3];
        GameStats gameStats = new GameStats();

        boolean roundFinished = false;
        boolean turnChanged = false;

        Player currentPlayer;

        do{
            DrawerBoard.drawBoard(playersMoves, gameStats);

            if(turnChanged){
                currentPlayer = Player.O;
                turnChanged = false;
            }else {
                currentPlayer = Player.X;
                turnChanged = true;
            }
            System.out.println((currentPlayer == Player.X)? "X's turn:\n" : "O's turn:\n");

            System.out.println("Spot your move!!");

            System.out.print("Row:");
            int row = in.nextInt();
            System.out.print("Column:");
            int column = in.nextInt();

            playersMoves[row][column] = currentPlayer;

            if (GameResultChecker.checkWinner(playersMoves, currentPlayer))
                roundFinished = true;

            //clearConsole();
        }while(!roundFinished);


    }
}

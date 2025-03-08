package ui;

//import logic.Player;

import logic.DrawerBoard;
import logic.GameStats;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;

public class Controller implements ActionListener {
    private final GameState gameState;
    private Spot currentButton;

    private JLabel playerTurnLabel;
    private JLabel x_winsLabel;
    private JLabel o_winsLabel;

    public Controller(GameState gameState, JLabel playerTurnLabel, JLabel x_winsLabel, JLabel o_winsLabel) {
        this.gameState = gameState;

        this.playerTurnLabel = playerTurnLabel;
        this.x_winsLabel = x_winsLabel;
        this.o_winsLabel = o_winsLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        currentButton = (Spot) e.getSource();
        setIcon();
        addMove();

        if(gameState.isRoundWon()){
            Component container = currentButton.getParent();
            for(Component component: ((JPanel) container).getComponents()){
                component.setEnabled(false);
            }
            gameState.updateStats();
            updateStatsLabel();
            //paintButtonsWinner();
        }

        if(!gameState.isRoundWon() && gameState.isBoardFull()){
            Component panel = currentButton.getParent();
            JOptionPane.showMessageDialog(panel, "Draw!", "Draw", JOptionPane.ERROR_MESSAGE);
        }

        gameState.changePlayer();
    }

    public void addMove(){
        gameState.addMove(currentButton.getRow(), currentButton.getColumn());
    }

    public void setIcon(){
        currentButton.setFont(new Font("DejaVu Sans", Font.BOLD,50));
        if(gameState.getCurrentPLayer() == Player.X){
            playerTurnLabel.setText("O's Turn:");
            currentButton.setText("X");

        }else{
            playerTurnLabel.setText("X's Turn:");
            currentButton.setText("0");
        }
    }

    public void setCurrentButton(Spot currentButton) {
        this.currentButton = currentButton;
    }

    public void updateStatsLabel(){
        x_winsLabel.setText("X's wins: " + gameState.getGameStats().getX_wins());
        o_winsLabel.setText("O's wins: " + gameState.getGameStats().getO_wins());
    }

    public void paintButtonsWinner(){
        Player[][] playersMoves = gameState.getPlayersMoves();
        Player currentPlayer = gameState.getCurrentPLayer();
        Component container = currentButton.getParent();

        //implement a matrix of buttons which can determiine easily the click
        Component component;
        for(int i = 0; i < 3; i++){
            if((playersMoves[i][0] == currentPlayer && playersMoves[i][1] == currentPlayer && playersMoves[i][2] == currentPlayer)){

            }

            if(playersMoves[0][i] == currentPlayer && playersMoves[1][i] == currentPlayer && playersMoves[2][i] == currentPlayer){

            }

        }

        if((playersMoves[0][0] == currentPlayer && playersMoves[1][1] == currentPlayer && playersMoves[2][2] == currentPlayer)){

        }

        if (playersMoves[2][0] == currentPlayer && playersMoves[1][1] == currentPlayer && playersMoves[0][2] == currentPlayer){

        }
    }
}


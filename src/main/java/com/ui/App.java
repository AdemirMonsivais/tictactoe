package ui;

import logic.GameStats;
import logic.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {
    private JPanel boardPanel;
    private JPanel statsPanel;

    private JLabel x_winsLabel;
    private JLabel o_winsLabel;

    private Spot button1;
    private Spot button2;
    private Spot button3;
    private Spot button4;
    private Spot button5;
    private Spot button6;
    private Spot button7;
    private Spot button8;
    private Spot button9;

    private JButton restartButton;
    //vertical left gap | vertical right gap
    private JPanel vLeftGap;
    private JPanel vRightGap;
    private JPanel hBottomGap;

    private Controller controller;
    private GameState gameState;

    private JLabel playerTurnLabel;

    public App(){

        gameState = new GameState();
        GameStats gameStats = gameState.getGameStats();

        setTitle("Tic Tac Toe");
        setSize(520,520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(40,40));

        x_winsLabel = new JLabel("X's wins: 0 ");
        o_winsLabel = new JLabel("O's wins: 0 ");

        JPanel playerTurnPanel = new JPanel();
        playerTurnLabel = new JLabel("X's Turn:");
        playerTurnLabel.setFont(new Font("Nimbus Sans", Font.BOLD, 35));
        playerTurnPanel.add(playerTurnLabel);

        JPanel restartPanel = new JPanel();
        restartButton = new JButton("Restart");
        restartPanel.add(restartButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        restartButton.addActionListener(e->{
            gameState.restart();

            playerTurnLabel.setText("X's Turn:");
            for(Component button: boardPanel.getComponents()){
                ((Spot)button).setText("");
                ((Spot)button).setEnabled(true);
            }

        });

        //vRightGap.setPreferredSize(new Dimension(50,20));

        statsPanel = new JPanel();
        statsPanel.setLayout(new FlowLayout());

        controlPanel.add(statsPanel);
        controlPanel.add(restartPanel);

        statsPanel.add(x_winsLabel);
        statsPanel.add(o_winsLabel);

        boardPanel = new JPanel(new GridLayout(3,3));

        button1 = new Spot( 0,0);
        button2 = new Spot(0,1);
        button3 = new Spot(0,2);
        button4 = new Spot(1,0);
        button5 = new Spot(1,1);
        button6 = new Spot(1,2);
        button7 = new Spot(2,0);
        button8 = new Spot(2,1);
        button9 = new Spot(2,2);

        boardPanel.add(button1);
        boardPanel.add(button2);
        boardPanel.add(button3);
        boardPanel.add(button4);
        boardPanel.add(button5);
        boardPanel.add(button6);
        boardPanel.add(button7);
        boardPanel.add(button8);
        boardPanel.add(button9);

        //boardPanel.setBackground(Color.BLUE);
        for(Component button: boardPanel.getComponents()){
            ((Spot)button).addActionListener(new Controller(gameState, playerTurnLabel, x_winsLabel, o_winsLabel ));
            ((Spot)button).setFocusPainted(false);
            ((Spot)button).setOpaque(false);
        }

        vLeftGap = new JPanel();
        vLeftGap.setPreferredSize(new Dimension(50,0));
        vRightGap = new JPanel();
        vRightGap.setPreferredSize(new Dimension(50,0));

        //hBottomGap = new JPanel();
        //hBottomGap.setPreferredSize(new Dimension(0,40));

        add(playerTurnPanel, BorderLayout.PAGE_START);
        add(boardPanel, BorderLayout.CENTER);
        //add(statsPanel, BorderLayout.PAGE_END);
        add(controlPanel, BorderLayout.PAGE_END);

        add(vLeftGap, BorderLayout.LINE_START);
        add(vRightGap, BorderLayout.LINE_END);
        //add(hBottomGap, BorderLayout.PAGE_END);
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

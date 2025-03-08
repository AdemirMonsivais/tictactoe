package ui;

import logic.Player;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spot extends JButton implements ActionListener{
    private int row;
    private int column;

    private Controller controller;

    public Spot( int row, int column){
        this.row = row;
        this.column = column;
        addActionListener(this);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setEnabled(false);
    }
}

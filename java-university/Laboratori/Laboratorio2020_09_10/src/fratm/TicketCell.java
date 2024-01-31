package fratm;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class TicketCell extends JPanel {
    private static final Color SELECTED = Color.GREEN;
    private static final Color UNSELECTED = Color.WHITE;
    private int value;
    private String S;
    JLabel valueLabel;
    JTextArea smorfia;

    public TicketCell() {
        this(0, false);
    }

    public TicketCell(int value) {
        this(value, false);
    }

    public TicketCell(int value, boolean selected) {
        this.valueLabel = new JLabel();
        this.valueLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        this.valueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        this.smorfia = new JTextArea();
        this.smorfia.setFont(new Font(Font.MONOSPACED, Font.BOLD,15));
      
        setLayout(new GridLayout(2, 1));
        add(this.smorfia);
        add(this.valueLabel);
        setValue(value,S);
        setSelected(selected);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value,String S) {
        this.value = value;
        valueLabel.setText(value > 0 && value <= 90 ? String.valueOf(value) : "");
        smorfia.setText(S);
        valueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        repaint();
    }

    public void setSelected(boolean selected) {
        if (selected) {
        	smorfia.setBackground(SELECTED);
            setBackground(SELECTED);
        } else {
        	smorfia.setBackground(UNSELECTED);
            setBackground(UNSELECTED);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 100);
    }

}
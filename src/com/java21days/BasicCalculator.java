package com.java21days;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BasicCalculator extends JFrame implements ActionListener, FocusListener {
    Dimension dim = new Dimension(100, 150);
    Float result;
    JLabel resultLabel;

    BasicCalculator(){
        super("Basic Calculator");
        setSize(dim);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JTextField num1 = new JTextField("0", 6);
        num1.addFocusListener(this);
        JTextField num2 = new JTextField("0", 6);
        num2.addFocusListener(this);
        panel.add(num1);
        panel.add(num2);
        JButton add = new JButton("+");
        add.addActionListener(this);
        JButton subtract = new JButton("-");
        subtract.addActionListener(this);
        panel.add(add);
        panel.add(subtract);
        resultLabel = new JLabel("Result here");
        panel.add(resultLabel);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Action performed");
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        JTextField selected = (JTextField) focusEvent.getSource();
        selected.setText("");
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        JTextField unselected = (JTextField) focusEvent.getSource();
        try {
            Float number = Float.parseFloat(unselected.getText());
            System.out.println((number));
        } catch (NumberFormatException nfe){
            unselected.setText("0");
        }
    }
}

package com.java21days;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BasicCalculator extends JFrame implements ActionListener, FocusListener {
    Dimension dim = new Dimension(100, 150);
    String result;
    JLabel resultLabel;
    JTextField num1, num2;

    BasicCalculator(){
        super("Basic Calculator");
        setSize(dim);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        num1 = new JTextField("0", 8);
        num1.addFocusListener(this);
        num2 = new JTextField("0", 8);
        num2.addFocusListener(this);
        panel.add(num1);
        panel.add(num2);
        JButton add = new JButton("+");
        add.addActionListener(this);
        JButton subtract = new JButton("-");
        subtract.addActionListener(this);
        panel.add(add);
        panel.add(subtract);
        result = "Result here";
        resultLabel = new JLabel(result);
        panel.add(resultLabel);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand() == "+"){
            Float floatResult = Float.parseFloat(num1.getText()) + Float.parseFloat(num2.getText());
            result = floatResult.toString();
            resultLabel.setText(result);
        } else{
            Float floatResult = Float.parseFloat(num1.getText()) - Float.parseFloat(num2.getText());
            result = floatResult.toString();
            resultLabel.setText(result);
        }
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

package com.java21days;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JFrame implements ActionListener {
    Dimension dim = new Dimension(500, 200);
    Float result;
    JLabel resultLabel;






    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Action performed");
    }
}

package com.tnstc.ui;

import java.awt.*;
import javax.swing.*;

public class PaymentPanel extends JPanel {
    private final JToggleButton btnCash = new JToggleButton("CASH PAY", true);
    private final JToggleButton btnUpi = new JToggleButton("UPI PAY");

    public PaymentPanel() {
        setLayout(new GridLayout(1, 2, 5, 5));
        ButtonGroup group = new ButtonGroup();
        group.add(btnCash);
        group.add(btnUpi);

        btnCash.setBackground(new Color(46, 139, 87));
        btnUpi.setBackground(new Color(30, 60, 180));

        add(btnCash);
        add(btnUpi);
    }

    public String getSelectedMode() {
        return btnUpi.isSelected() ? "UPI" : "CASH";
    }
}
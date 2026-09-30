package com.tnstc.ui;

import java.awt.*;
import java.util.function.Consumer;
import javax.swing.*;

public class PassengerCounterPanel extends JPanel {
    private int adults = 1, children = 0, handicap = 0, transgender = 0, luggage = 0;

    private final JLabel lblAdult = new JLabel("1", SwingConstants.CENTER);
    private final JLabel lblChild = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblHandicap = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblTrans = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblLuggage = new JLabel("0", SwingConstants.CENTER);

    public PassengerCounterPanel(Consumer<Void> onChange) {
        setLayout(new GridLayout(5, 4, 5, 5));

        addRow("Adults:", lblAdult, () -> adults, v -> adults = v, onChange);
        addRow("Children:", lblChild, () -> children, v -> children = v, onChange);
        addRow("Handicap:", lblHandicap, () -> handicap, v -> handicap = v, onChange);
        addRow("Transgender:", lblTrans, () -> transgender, v -> transgender = v, onChange);
        addRow("Luggage Items:", lblLuggage, () -> luggage, v -> luggage = v, onChange);
    }

    private void addRow(String labelText, JLabel displayLabel, java.util.function.Supplier<Integer> getter, Consumer<Integer> setter, Consumer<Void> onChange) {
        JButton btnMinus = new JButton("-");
        JButton btnPlus = new JButton("+");

        btnMinus.addActionListener(e -> {
            if (getter.get() > 0) {
                setter.accept(getter.get() - 1);
                displayLabel.setText(String.valueOf(getter.get()));
                onChange.accept(null);
            }
        });

        btnPlus.addActionListener(e -> {
            setter.accept(getter.get() + 1);
            displayLabel.setText(String.valueOf(getter.get()));
            onChange.accept(null);
        });

        add(new JLabel(" " + labelText));
        add(btnMinus);
        add(displayLabel);
        add(btnPlus);
    }

    public int getAdults() { return adults; }
    public int getChildren() { return children; }
    public int getHandicap() { return handicap; }
    public int getTransgender() { return transgender; }
    public int getLuggage() { return luggage; }
}
package com.tnstc.ui;

import com.tnstc.db.BusDAO;
import com.tnstc.model.Bus;

import javax.swing.*;
import java.awt.*;

public class BusSelectionDialog extends JDialog {
    private JComboBox<Bus> busComboBox;
    private JTextField tripNumberField;
    private JComboBox<String> directionComboBox;
    private Bus selectedBus;
    private int tripNumber;
    private String direction;
    private boolean confirmed = false;

    public BusSelectionDialog(Frame parent) {
        super(parent, "TNSTC Machine Initialization", true);
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(420, 220);
        setLocationRelativeTo(parent);

        add(new JLabel(" Select Bus/Service:"));
        busComboBox = new JComboBox<>();
        new BusDAO().getAllBuses().forEach(busComboBox::addItem);
        add(busComboBox);

        if (busComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this,
                "No buses found in the database.\nCheck db.properties and that sample_data.sql was run.",
                "Database Empty", JOptionPane.WARNING_MESSAGE);
        }

        add(new JLabel(" Trip Number:"));
        tripNumberField = new JTextField("1");
        add(tripNumberField);

        add(new JLabel(" Direction:"));
        directionComboBox = new JComboBox<>(new String[]{"UP", "DN"});
        add(directionComboBox);

        JButton btnStart = new JButton("Start Trip");
        btnStart.addActionListener(e -> {
            selectedBus = (Bus) busComboBox.getSelectedItem();
            direction = (String) directionComboBox.getSelectedItem();
            try {
                tripNumber = Integer.parseInt(tripNumberField.getText());
                confirmed = true;
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Trip Number must be valid!");
            }
        });

        add(new JLabel(""));
        add(btnStart);
    }

    public boolean isConfirmed() { return confirmed; }
    public Bus getSelectedBus() { return selectedBus; }
    public int getTripNumber() { return tripNumber; }
    public String getDirection() { return direction; }
}
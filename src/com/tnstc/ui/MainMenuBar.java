package com.tnstc.ui;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(Runnable onEndTrip) {
        JMenu menu = new JMenu("System");
        JMenuItem endTripItem = new JMenuItem("End Current Trip");

        endTripItem.addActionListener(e -> onEndTrip.run());

        menu.add(endTripItem);
        add(menu);
    }
}
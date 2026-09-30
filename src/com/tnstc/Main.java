package com.tnstc;

import com.tnstc.db.TripDAO;
import com.tnstc.model.Bus;
import com.tnstc.model.Trip;
import com.tnstc.ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TNSTC Electronic Bus Ticket Machine Simulator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            BusSelectionDialog dialog = new BusSelectionDialog(frame);
            dialog.setVisible(true);

            if (!dialog.isConfirmed()) {
                System.exit(0);
            }

            Bus bus = dialog.getSelectedBus();
            if (bus == null) {
                JOptionPane.showMessageDialog(null,
                    "No bus was selected (bus list may be empty - check your database connection and that sample_data.sql was run).");
                System.exit(1);
            }

            TripDAO tripDAO = new TripDAO();
            Trip trip = tripDAO.createTrip(bus.getBusId(), dialog.getTripNumber(), dialog.getDirection());

            if (trip == null) {
                JOptionPane.showMessageDialog(null, "Database Connection Failed or couldn't start trip!");
                System.exit(1);
            }

            TicketScreen ticketScreen = new TicketScreen(bus, trip);
            frame.setJMenuBar(new MainMenuBar(() -> {
                tripDAO.closeTrip(trip.getTripId());
                new TripSummaryScreen(frame, trip).setVisible(true);
            }));

            frame.setContentPane(ticketScreen);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
package com.tnstc.ui;

import com.tnstc.db.TicketDAO;
import com.tnstc.model.Trip;
import java.awt.*;
import javax.swing.*;

public class TripSummaryScreen extends JDialog {
    public TripSummaryScreen(Frame parent, Trip trip) {
        super(parent, "Trip Summary Report", true);
        setLayout(new GridLayout(4, 1, 10, 10));
        setSize(350, 200);
        setLocationRelativeTo(parent);

        TicketDAO dao = new TicketDAO();
        int ticketCount = dao.getTicketCountForTrip(trip.getTripId());
        double totalAmt = dao.getTotalCollectionForTrip(trip.getTripId());

        add(new JLabel(" Trip ID: " + trip.getTripId() + " | Direction: " + trip.getDirection(), SwingConstants.CENTER));
        add(new JLabel(" Total Tickets Issued: " + ticketCount, SwingConstants.CENTER));
        add(new JLabel(String.format(" Total Collection: Rs.%.2f", totalAmt), SwingConstants.CENTER));

        JButton btnClose = new JButton("Close & Exit");
        btnClose.addActionListener(e -> System.exit(0));
        add(btnClose);
    }
}
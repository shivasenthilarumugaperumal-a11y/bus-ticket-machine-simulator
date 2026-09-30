package com.tnstc.ui;

import com.tnstc.db.BusDAO;
import com.tnstc.db.TicketDAO;
import com.tnstc.db.TripDAO;
import com.tnstc.model.*;
import com.tnstc.service.FareCalculator;
import com.tnstc.service.TicketNumberGenerator;
import com.tnstc.util.ImageExporter;
import com.tnstc.util.TicketImageRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class TicketScreen extends JPanel {
    private Bus bus;
    private Trip trip;
    private JComboBox<Stage> comboFrom;
    private JComboBox<Stage> comboTo;
    private PassengerCounterPanel counterPanel;
    private PaymentPanel paymentPanel;
    private JLabel lblTotalFare;
    private JLabel lblDistance;
    private JLabel lblTicketPreview;

    public TicketScreen(Bus bus, Trip trip) {
        this.bus = bus;
        this.trip = trip;
        setLayout(new BorderLayout(10, 10));

        JPanel controlPanel = new JPanel(new GridLayout(6, 1, 5, 5));

        List<Stage> stages = new BusDAO().getStagesForBus(bus.getBusId());
        comboFrom = new JComboBox<>();
        comboTo = new JComboBox<>();
        stages.forEach(s -> {
            comboFrom.addItem(s);
            comboTo.addItem(s);
        });

        if (trip.getDirection().equals("DN") && stages.size() > 1) {
            comboFrom.setSelectedIndex(stages.size() - 1);
            comboTo.setSelectedIndex(0);
        } else if (stages.size() > 1) {
            comboTo.setSelectedIndex(1);
        }

        JPanel stagePanel = new JPanel(new GridLayout(2, 2));
        stagePanel.add(new JLabel(" Boarding Stage:"));
        stagePanel.add(comboFrom);
        stagePanel.add(new JLabel(" Alighting Stage:"));
        stagePanel.add(comboTo);

        counterPanel = new PassengerCounterPanel(v -> updateFare());
        paymentPanel = new PaymentPanel();

        lblDistance = new JLabel(" Distance: 0.00 km", SwingConstants.CENTER);
        lblTotalFare = new JLabel(" Total: Rs.0.00", SwingConstants.CENTER);
        lblTotalFare.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnPrint = new JButton("PRINT TICKET");
        btnPrint.setFont(new Font("Arial", Font.BOLD, 14));

        controlPanel.add(stagePanel);
        controlPanel.add(counterPanel);
        controlPanel.add(paymentPanel);
        controlPanel.add(lblDistance);
        controlPanel.add(lblTotalFare);
        controlPanel.add(btnPrint);

        lblTicketPreview = new JLabel();
        lblTicketPreview.setHorizontalAlignment(SwingConstants.CENTER);

        add(controlPanel, BorderLayout.WEST);
        add(new JScrollPane(lblTicketPreview), BorderLayout.CENTER);

        comboFrom.addActionListener(e -> {
            Stage from = (Stage) comboFrom.getSelectedItem();
            if (from != null) {
                new TripDAO().updateCurrentBoardingStage(trip.getTripId(), from.getStageNo());
            }
            updateFare();
        });

        comboTo.addActionListener(e -> updateFare());
        btnPrint.addActionListener(e -> issueTicket());

        updateFare();
    }

    private void updateFare() {
        Stage from = (Stage) comboFrom.getSelectedItem();
        Stage to = (Stage) comboTo.getSelectedItem();
        if (from != null && to != null) {
            double distance = FareCalculator.calculateDistance(from, to);
            double fare = FareCalculator.calculateTotalFare(
                bus, from.getStageNo(), to.getStageNo(),
                counterPanel.getAdults(), counterPanel.getChildren(),
                counterPanel.getHandicap(), counterPanel.getTransgender(),
                counterPanel.getLuggage()
            );
            lblDistance.setText(String.format(" Distance: %.2f km", distance));
            lblTotalFare.setText(String.format(" Total: Rs.%.2f", fare));
        }
    }

    private void issueTicket() {
        Stage from = (Stage) comboFrom.getSelectedItem();
        Stage to = (Stage) comboTo.getSelectedItem();

        if (from.getStageNo() == to.getStageNo()) {
            JOptionPane.showMessageDialog(this, "Boarding and Alighting stages cannot be identical!");
            return;
        }

        double distance = FareCalculator.calculateDistance(from, to);
        double totalFare = FareCalculator.calculateTotalFare(
            bus, from.getStageNo(), to.getStageNo(),
            counterPanel.getAdults(), counterPanel.getChildren(),
            counterPanel.getHandicap(), counterPanel.getTransgender(),
            counterPanel.getLuggage()
        );

        TicketDAO ticketDAO = new TicketDAO();
        int nextSeq = ticketDAO.getTicketCountForTrip(trip.getTripId()) + 1;
        String ticketNo = TicketNumberGenerator.generateTicketNumber(trip.getDirection(), trip.getTripNo(), nextSeq);

        Ticket ticket = new Ticket(
            ticketNo, trip.getTripId(), from.getStageNo(), to.getStageNo(),
            counterPanel.getAdults(), counterPanel.getChildren(),
            counterPanel.getHandicap(), counterPanel.getTransgender(),
            counterPanel.getLuggage(), distance, totalFare, paymentPanel.getSelectedMode()
        );

        if (ticketDAO.saveTicket(ticket)) {
            BufferedImage image = TicketImageRenderer.renderTicket(ticket, bus, from.getStageName(), to.getStageName());
            ImageExporter.exportTicketAsPNG(image, ticketNo);
            lblTicketPreview.setIcon(new ImageIcon(image));
            JOptionPane.showMessageDialog(this, "Ticket Issued & Saved Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to persist ticket to database!");
        }
    }
}
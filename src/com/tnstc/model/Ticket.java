package com.tnstc.model;

import java.sql.Timestamp;

public class Ticket {
    private int ticketId;
    private String formattedTicketNo;
    private int tripId;
    private int boardingStageNo;
    private int alightingStageNo;
    private int adult;
    private int children;
    private int handicap;
    private int transgender;
    private int luggage;
    private double distanceKm;
    private double totalFare;
    private String paymentMode; // CASH or UPI
    private Timestamp issuedAt;

    public Ticket(String formattedTicketNo, int tripId, int boardingStageNo, int alightingStageNo,
                  int adult, int children, int handicap, int transgender, int luggage,
                  double distanceKm, double totalFare, String paymentMode) {
        this.formattedTicketNo = formattedTicketNo;
        this.tripId = tripId;
        this.boardingStageNo = boardingStageNo;
        this.alightingStageNo = alightingStageNo;
        this.adult = adult;
        this.children = children;
        this.handicap = handicap;
        this.transgender = transgender;
        this.luggage = luggage;
        this.distanceKm = distanceKm;
        this.totalFare = totalFare;
        this.paymentMode = paymentMode;
    }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }
    public String getFormattedTicketNo() { return formattedTicketNo; }
    public int getTripId() { return tripId; }
    public int getBoardingStageNo() { return boardingStageNo; }
    public int getAlightingStageNo() { return alightingStageNo; }
    public int getAdult() { return adult; }
    public int getChildren() { return children; }
    public int getHandicap() { return handicap; }
    public int getTransgender() { return transgender; }
    public int getLuggage() { return luggage; }
    public double getDistanceKm() { return distanceKm; }
    public double getTotalFare() { return totalFare; }
    public String getPaymentMode() { return paymentMode; }
    public Timestamp getIssuedAt() { return issuedAt; }
    public void setIssuedAt(Timestamp issuedAt) { this.issuedAt = issuedAt; }
}
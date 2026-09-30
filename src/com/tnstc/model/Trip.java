package com.tnstc.model;

import java.sql.Timestamp;

public class Trip {
    private int tripId;
    private int busId;
    private int tripNo;
    private String direction; // UP or DN
    private int currentBoardingStage;
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean closed;

    public Trip(int tripId, int busId, int tripNo, String direction,
                int currentBoardingStage, Timestamp startTime, Timestamp endTime, boolean closed) {
        this.tripId = tripId;
        this.busId = busId;
        this.tripNo = tripNo;
        this.direction = direction;
        this.currentBoardingStage = currentBoardingStage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.closed = closed;
    }

    public int getTripId() { return tripId; }
    public int getBusId() { return busId; }
    public int getTripNo() { return tripNo; }
    public String getDirection() { return direction; }
    public int getCurrentBoardingStage() { return currentBoardingStage; }
    public void setCurrentBoardingStage(int currentBoardingStage) { this.currentBoardingStage = currentBoardingStage; }
    public Timestamp getStartTime() { return startTime; }
    public Timestamp getEndTime() { return endTime; }
    public boolean isClosed() { return closed; }
}
package com.tnstc.model;

public class Stage {
    private int stageId;
    private int busId;
    private int stageNo;
    private String stageName;
    private double distanceFromOrigin;

    public Stage(int stageId, int busId, int stageNo, String stageName, double distanceFromOrigin) {
        this.stageId = stageId;
        this.busId = busId;
        this.stageNo = stageNo;
        this.stageName = stageName;
        this.distanceFromOrigin = distanceFromOrigin;
    }

    public int getStageId() { return stageId; }
    public int getBusId() { return busId; }
    public int getStageNo() { return stageNo; }
    public String getStageName() { return stageName; }
    public double getDistanceFromOrigin() { return distanceFromOrigin; }

    @Override
    public String toString() {
        return stageNo + ". " + stageName;
    }
}
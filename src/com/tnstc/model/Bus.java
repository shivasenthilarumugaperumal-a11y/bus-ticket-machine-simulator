package com.tnstc.model;

public class Bus {
    private int busId;
    private String regionName;
    private String subRegion;
    private String depotName;
    private String serviceNumber;
    private String busCategory; // TOWN or MOFUSSIL
    private String busType;
    private String vehicleRegNo;
    private double luggageFare;
    private String ticketClass;

    public Bus(int busId, String regionName, String subRegion, String depotName,
               String serviceNumber, String busCategory, String busType,
               String vehicleRegNo, double luggageFare, String ticketClass) {
        this.busId = busId;
        this.regionName = regionName;
        this.subRegion = subRegion;
        this.depotName = depotName;
        this.serviceNumber = serviceNumber;
        this.busCategory = busCategory;
        this.busType = busType;
        this.vehicleRegNo = vehicleRegNo;
        this.luggageFare = luggageFare;
        this.ticketClass = ticketClass;
    }

    public int getBusId() { return busId; }
    public String getRegionName() { return regionName; }
    public String getSubRegion() { return subRegion; }
    public String getDepotName() { return depotName; }
    public String getServiceNumber() { return serviceNumber; }
    public String getBusCategory() { return busCategory; }
    public String getBusType() { return busType; }
    public String getVehicleRegNo() { return vehicleRegNo; }
    public double getLuggageFare() { return luggageFare; }
    public String getTicketClass() { return ticketClass; }

    @Override
    public String toString() {
        return serviceNumber + " - " + vehicleRegNo + " (" + busType + ")";
    }
}
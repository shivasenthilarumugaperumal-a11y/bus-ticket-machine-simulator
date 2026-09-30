package com.tnstc.service;

public class TicketNumberGenerator {

    /**
     * Builds a ticket number in your specified format:
     *   T{UP/DN}{TripNo, 4 digits}T{TicketNo within trip, 3 digits}
     * e.g. direction="UP", tripNo=10, ticketSeq=34 -> "TUP0010T034"
     */
    public static String generateTicketNumber(String direction, int tripNo, int ticketSeq) {
        return String.format("T%s%04dT%03d", direction, tripNo, ticketSeq);
    }
}
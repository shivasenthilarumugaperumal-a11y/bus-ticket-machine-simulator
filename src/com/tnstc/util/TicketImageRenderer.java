package com.tnstc.util;

import com.tnstc.model.Bus;
import com.tnstc.model.Ticket;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TicketImageRenderer {
    public static BufferedImage renderTicket(Ticket ticket, Bus bus, String fromName, String toName) {
        int width = 320;
        int height = 520;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);

        g.setFont(new Font("Monospaced", Font.BOLD, 13));
        g.drawString(bus.getRegionName().toUpperCase(), 30, 20);
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g.drawString("Depot: " + bus.getDepotName(), 20, 38);
        g.drawString("Bus No: " + bus.getVehicleRegNo() + " (" + bus.getServiceNumber() + ")", 20, 52);
        g.drawString("Class: " + bus.getTicketClass() + " [" + bus.getBusCategory() + "]", 20, 66);
        g.drawString("-----------------------------------", 15, 80);

        g.drawString("Ticket No: " + ticket.getFormattedTicketNo(), 20, 96);
        g.drawString("From : " + fromName, 20, 112);
        g.drawString("To   : " + toName, 20, 128);
        g.drawString("Dist : " + ticket.getDistanceKm() + " km", 20, 144);
        g.drawString("-----------------------------------", 15, 158);

        g.drawString("Adults: " + ticket.getAdult() + " | Children: " + ticket.getChildren(), 20, 174);
        g.drawString("Handicap: " + ticket.getHandicap() + " | Transgender: " + ticket.getTransgender(), 20, 190);
        g.drawString("Luggage Items: " + ticket.getLuggage(), 20, 206);
        g.drawString("Payment Mode : " + ticket.getPaymentMode(), 20, 222);

        g.setFont(new Font("Monospaced", Font.BOLD, 15));
        g.drawString(String.format("TOTAL: Rs.%.2f", ticket.getTotalFare()), 20, 250);

        if (ticket.getPaymentMode().equals("UPI")) {
            BufferedImage qr = QRGenerator.generateQRCode(ticket.getFormattedTicketNo(), ticket.getTotalFare(), 140, 140);
            if (qr != null) {
                g.drawImage(qr, 90, 275, null);
            }
        } else {
            g.setFont(new Font("Monospaced", Font.PLAIN, 11));
            g.drawString("** PAID IN CASH **", 95, 345);
        }

        g.setFont(new Font("Monospaced", Font.ITALIC, 9));
        g.drawString("Sub Region: " + (bus.getSubRegion() != null ? bus.getSubRegion() : "N/A"), 20, 440);
        g.drawString("Wish You A Safe Journey!", 80, 460);
        g.drawString("-----------------------------------", 15, 475);

        g.dispose();
        return image;
    }
}
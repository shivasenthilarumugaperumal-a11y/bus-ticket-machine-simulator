package com.tnstc.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageExporter {

    private static final String OUTPUT_DIR = "output/tickets";

    public static void exportTicketAsPNG(BufferedImage image, String ticketNo) {
        try {
            File dir = new File(OUTPUT_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String safeName = ticketNo.replaceAll("[^A-Za-z0-9]", "_");
            File outFile = new File(dir, safeName + ".png");
            ImageIO.write(image, "png", outFile);
            System.out.println("Ticket image saved: " + outFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
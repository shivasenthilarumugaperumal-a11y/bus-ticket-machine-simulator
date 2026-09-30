package com.tnstc.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.tnstc.db.DBConnection;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QRGenerator {

    public static BufferedImage generateQRCode(String ticketNo, double amount, int width, int height) {
        try {
            String vpa = DBConnection.getUpiVpa();
            String payeeName = DBConnection.getUpiPayeeName();

            if (vpa == null || vpa.isBlank()) {
                System.err.println("upi.vpa is not set in db.properties - cannot generate QR.");
                return null;
            }

            String upiString = "upi://pay?pa=" + vpa
                    + "&pn=" + URLEncoder.encode(payeeName != null ? payeeName : "TNSTC", "UTF-8")
                    + "&am=" + String.format("%.2f", amount)
                    + "&cu=INR"
                    + "&tn=" + URLEncoder.encode(ticketNo, "UTF-8");

            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(upiString, BarcodeFormat.QR_CODE, width, height);
            return MatrixToImageWriter.toBufferedImage(matrix);

        } catch (WriterException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
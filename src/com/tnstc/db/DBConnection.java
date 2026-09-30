package com.tnstc.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String user;
    private static String password;
    private static String upiVpa;
    private static String upiPayeeName;

    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                url = prop.getProperty("db.url");
                user = prop.getProperty("db.user");
                password = prop.getProperty("db.password");
                upiVpa = prop.getProperty("upi.vpa");
                upiPayeeName = prop.getProperty("upi.payeeName");
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Database connection successful: " + connection.getMetaData().getURL());
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            System.exit(1);
        }
    }

    public static String getUpiVpa() { return upiVpa; }
    public static String getUpiPayeeName() { return upiPayeeName; }
}
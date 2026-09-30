package com.tnstc.db;

import com.tnstc.model.Bus;
import com.tnstc.model.Stage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String query = "SELECT * FROM bus";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                buses.add(new Bus(
                    rs.getInt("bus_id"),
                    rs.getString("region_name"),
                    rs.getString("sub_region"),
                    rs.getString("depot_name"),
                    rs.getString("service_number"),
                    rs.getString("bus_category"),
                    rs.getString("bus_type"),
                    rs.getString("vehicle_reg_no"),
                    rs.getDouble("luggage_fare"),
                    rs.getString("ticket_class")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buses;
    }

    public List<Stage> getStagesForBus(int busId) {
        List<Stage> stages = new ArrayList<>();
        String query = "SELECT * FROM stage WHERE bus_id = ? ORDER BY stage_no ASC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, busId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                stages.add(new Stage(
                    rs.getInt("stage_id"),
                    rs.getInt("bus_id"),
                    rs.getInt("stage_no"),
                    rs.getString("stage_name"),
                    rs.getDouble("distance_from_origin")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stages;
    }
}
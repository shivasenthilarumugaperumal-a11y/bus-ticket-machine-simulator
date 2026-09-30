package com.tnstc.db;

import com.tnstc.model.Trip;
import java.sql.*;

public class TripDAO {
    public Trip createTrip(int busId, int tripNo, String direction) {
        String sql = "INSERT INTO trip (bus_id, trip_no, direction, current_boarding_stage, start_time, closed) VALUES (?, ?, ?, 1, NOW(), FALSE)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, busId);
            pstmt.setInt(2, tripNo);
            pstmt.setString(3, direction);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return new Trip(id, busId, tripNo, direction, 1, new Timestamp(System.currentTimeMillis()), null, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCurrentBoardingStage(int tripId, int stageNo) {
        String sql = "UPDATE trip SET current_boarding_stage = ? WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stageNo);
            pstmt.setInt(2, tripId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeTrip(int tripId) {
        String sql = "UPDATE trip SET end_time = NOW(), closed = TRUE WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tripId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
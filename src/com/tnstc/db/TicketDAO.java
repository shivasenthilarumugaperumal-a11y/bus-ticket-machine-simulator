package com.tnstc.db;

import com.tnstc.model.Ticket;
import java.sql.*;

public class TicketDAO {
    public boolean saveTicket(Ticket ticket) {
        String sql = "INSERT INTO ticket (formatted_ticket_no, trip_id, boarding_stage_no, alighting_stage_no, " +
                     "adult, children, handicap, transgender, luggage, distance_km, total_fare, payment_mode, issued_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, ticket.getFormattedTicketNo());
            pstmt.setInt(2, ticket.getTripId());
            pstmt.setInt(3, ticket.getBoardingStageNo());
            pstmt.setInt(4, ticket.getAlightingStageNo());
            pstmt.setInt(5, ticket.getAdult());
            pstmt.setInt(6, ticket.getChildren());
            pstmt.setInt(7, ticket.getHandicap());
            pstmt.setInt(8, ticket.getTransgender());
            pstmt.setInt(9, ticket.getLuggage());
            pstmt.setDouble(10, ticket.getDistanceKm());
            pstmt.setDouble(11, ticket.getTotalFare());
            pstmt.setString(12, ticket.getPaymentMode());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    ticket.setTicketId(rs.getInt(1));
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public double getTotalCollectionForTrip(int tripId) {
        String sql = "SELECT SUM(total_fare) FROM ticket WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tripId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public int getTicketCountForTrip(int tripId) {
        String sql = "SELECT COUNT(*) FROM ticket WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tripId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
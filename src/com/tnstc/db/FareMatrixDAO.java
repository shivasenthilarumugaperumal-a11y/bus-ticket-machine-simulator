package com.tnstc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FareMatrixDAO {

    public double getBaseFare(int busId, int stageNo1, int stageNo2) {
        if (stageNo1 == stageNo2) return 0.0;

        String query = "SELECT fare FROM fare_matrix WHERE bus_id = ? "
                     + "AND from_stage_no = LEAST(?, ?) "
                     + "AND to_stage_no = GREATEST(?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, busId);
            pstmt.setInt(2, stageNo1);
            pstmt.setInt(3, stageNo2);
            pstmt.setInt(4, stageNo1);
            pstmt.setInt(5, stageNo2);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("fare");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
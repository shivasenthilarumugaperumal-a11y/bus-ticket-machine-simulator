package com.tnstc.service;

import com.tnstc.db.FareMatrixDAO;
import com.tnstc.model.Bus;
import com.tnstc.model.Stage;

public class FareCalculator {

    private static final FareMatrixDAO fareMatrixDAO = new FareMatrixDAO();

    public static double calculateDistance(Stage boarding, Stage alighting) {
        return Math.abs(alighting.getDistanceFromOrigin() - boarding.getDistanceFromOrigin());
    }

    public static double calculateTotalFare(Bus bus, int boardingStageNo, int alightingStageNo,
                                            int adults, int children, int handicap,
                                            int transgender, int luggageCount) {

        if (boardingStageNo == alightingStageNo) {
            return 0.0;
        }

        double singleAdultFare = fareMatrixDAO.getBaseFare(bus.getBusId(), boardingStageNo, alightingStageNo);

        double singleChildFare = Math.ceil(singleAdultFare / 2.0);
        double singleHandicapFare = 0;
        double singleTransgenderFare = singleAdultFare; // Charged full adult fare

        double passengerTotal = (adults * singleAdultFare)
                              + (transgender * singleTransgenderFare)
                              + (children * singleChildFare)
                              + (handicap * singleHandicapFare);

        double luggageTotal = luggageCount * bus.getLuggageFare();

        return passengerTotal + luggageTotal;
    }
}
package com.github.maximkirko.mavenwebapptest.utils;

import com.github.maximkirko.mavenwebapptest.models.violations.*;
import com.github.maximkirko.mavenwebapptest.models.violations.Violation;
import com.github.maximkirko.mavenwebapptest.models.violations.Violations;

/**
 * Created by Pavel on 12.10.2016.
 */
public class Utils {
    public static Violation getViolationFromEnum(Violations violationType) {
        switch(violationType) {
            case ParkingAtBusStop : return new ParkingAtBusStop();
            case ParkingNearRailroad: return new ParkingNearRailroad();
            case ParkingNearShop: return new ParkingNearShop();
            case ParkingOnBridge: return new ParkingOnBridge();
            case ParkingOnCrossing: return new ParkingOnCrossing();
            case ParkingOnGrass: return  new ParkingOnGrass();
            case ParkingOnLeftSide: return new ParkingOnLeftSide();
            case ParkingOnWalkway: return new ParkingOnWalkway();
            case ParkingUnderSign: return new ParkingUnderSign();
        }
        return null;
    }
}

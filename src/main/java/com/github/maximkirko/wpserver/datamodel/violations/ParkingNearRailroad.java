package com.github.maximkirko.wpserver.datamodel.violations;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingNearRailroad extends Violation {
    public ParkingNearRailroad() {
            setDescription("143.8. на железнодорожных переездах и ближе 50 метров от них в обе стороны.");
        }

    public Enum getType() {
        return ViolationType.ParkingNearRailroad;
    }
}

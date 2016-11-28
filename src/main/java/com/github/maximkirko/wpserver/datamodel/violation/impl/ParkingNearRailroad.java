package com.github.maximkirko.wpserver.datamodel.violation.impl;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingNearRailroad extends Violation {
    public ParkingNearRailroad() {
            setDescription("143.8. на железнодорожных переездах и ближе 50 метров от них в обе стороны.");
        }

}

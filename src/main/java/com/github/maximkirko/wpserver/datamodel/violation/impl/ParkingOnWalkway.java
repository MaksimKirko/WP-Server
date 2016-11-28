package com.github.maximkirko.wpserver.datamodel.violation.impl;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingOnWalkway extends Violation {
    public ParkingOnWalkway() {
        setDescription("143.14. на тротуарах, кроме специально отведенных мест, обозначенных" +
                " дорожным знаком «Место стоянки» («Место стоянки такси»).");
        }

}

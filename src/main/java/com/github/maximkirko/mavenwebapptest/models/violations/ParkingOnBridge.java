package com.github.maximkirko.mavenwebapptest.models.violations;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingOnBridge extends Violation{
    public ParkingOnBridge() {
            setDescription("143.6. на мостах, путепроводах, эстакадах и под ними, кроме специально " +
                    "оборудованных мест для стоянки.");
        }

    public Enum getType() {
        return Violations.ParkingOnBridge;
    }
}

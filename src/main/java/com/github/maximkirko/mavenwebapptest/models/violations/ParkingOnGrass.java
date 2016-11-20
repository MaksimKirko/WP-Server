package com.github.maximkirko.mavenwebapptest.models.violations;

/**
 * Created by Pavel on 03.10.2016.
 */
public class ParkingOnGrass extends Violation{
    public ParkingOnGrass() {
            setDescription("143.15. на газонах и других участках с зелеными насаждениями.");
        }

    public Enum getType() {
        return Violations.ParkingOnGrass;
    }
}

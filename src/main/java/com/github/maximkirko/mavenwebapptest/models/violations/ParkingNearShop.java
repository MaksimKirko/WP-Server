package com.github.maximkirko.mavenwebapptest.models.violations;

/**
 * Created by Pavel on 03.10.2016.
 */
public class ParkingNearShop extends Violation{
    public ParkingNearShop() {
            setDescription("143.18. ближе 10 метров от служебных дверей магазинов, через которые " +
                    "производятся погрузочно-разгрузочные работы, закрытых ворот, в том числе ворот гаражей.");
        }

    public Enum getType() {
        return Violations.ParkingNearShop;
    }
}

package com.github.maximkirko.mavenwebapptest.models.violations;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingAtBusStop extends Violation{
    public ParkingAtBusStop() {
        setDescription("143.5. на остановочных пунктах маршрутных транспортных средств и ближе " +
                "15 метров от них, кроме случаев остановки для посадки (высадки) пассажиров, если это не создаст " +
                "препятствия для движения маршрутных транспортных средств.");
    }

    public Enum getType() {
        return Violations.ParkingAtBusStop;
    }
}

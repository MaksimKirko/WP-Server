package com.github.maximkirko.mavenwebapptest.models.violations;

/**
 * Created by Pavel on 25.09.2016.
 */
public class ParkingUnderSign extends Violation{
    public ParkingUnderSign() {
            setDescription("143.1. В зоне действия соответственно дорожных знаков «Остановка запрещена»," +
                    " «Стоянка запрещена», «Стоянка запрещена по нечетным числам месяца»," +
                    " «Стоянка запрещена по четным числам месяца» и (или) линий горизонтальной дорожной разметки 1.4, 1.10.");
        }

    public Enum getType() {
        return Violations.ParkingUnderSign;
    }
}

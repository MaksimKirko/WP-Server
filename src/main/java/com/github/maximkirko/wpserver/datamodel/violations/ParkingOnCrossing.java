package com.github.maximkirko.wpserver.datamodel.violations;

/**
 * Created by Pavel on 04.10.2016.
 */
public class ParkingOnCrossing extends Violation {
    public ParkingOnCrossing() {
            setDescription("143.4. на перекрестках и ближе 15 метров от края пересекаемой проезжей части " +
                    "дороги (кроме жилых зон), за исключением стороны напротив бокового проезда трехсторонних перекрестков, " +
                    "имеющих сплошную линию горизонтальной дорожной разметки или сплошную разделительную полосу.");
        }

    public Enum getType() {
        return ViolationType.ParkingOnCrossing;
    }
}

package com.github.maximkirko.wpserver.datamodel.violation.impl;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;

/**
 * Created by Pavel on 03.10.2016.
 */
public class ParkingNearShop extends Violation {
    public ParkingNearShop() {
            setDescription("143.18. ближе 10 метров от служебных дверей магазинов, через которые " +
                    "производятся погрузочно-разгрузочные работы, закрытых ворот, в том числе ворот гаражей.");
        }

}

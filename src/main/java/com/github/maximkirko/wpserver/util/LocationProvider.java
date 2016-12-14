package com.github.maximkirko.wpserver.util;

import com.github.maximkirko.wpserver.datamodel.Coords;

/**
 * Created by Pavel on 14.12.2016.
 */
public class LocationProvider {

    public String getLocationURL(String loc) {

        String[] coords = loc.split(",+\\s");
        String latitude = coords[0];
        String longitude = coords[1];
        String locationUrl = "https://yandex.ru/maps/10274/grodno/?ll="+longitude+"%2C"+latitude+"&z=17";

        String newloc = "https://yandex.ru/maps/10274/grodno/?ll="+longitude+"%2C"+latitude+"&z=19&mode=whatshere&whatshere%5Bpoint%5D="+longitude+"%2C"+latitude+"&whatshere%5Bzoom%5D=17";
        return newloc;
    }
}

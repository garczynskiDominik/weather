package com.weatherapp.output;

import com.weatherapp.model.Localization;

import java.util.List;

public class UserOutput {

    public static void outputAllLocations(List<Localization> localizations) {
        System.out.println("=========== WSZYSTKIE ZAPISANE LOKALIZACJE ===========");
        for (Localization localization : localizations) {
            System.out.println(localization);
        }
    }

}

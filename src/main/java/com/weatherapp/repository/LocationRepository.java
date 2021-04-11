package com.weatherapp.repository;

import com.weatherapp.model.Localization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocationRepository {

    public List<Localization> localizations = new ArrayList<>();

    public void addLocation() {
        Localization location = new Localization();
        System.out.println("DODAWANIE NOWEJ LOKALIZACJI");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kraj: ");
        location.setCountry(scanner.nextLine());
        System.out.println("Podaj region: ");
        location.setRegion(scanner.nextLine());
        System.out.println("Podaj szerokość geograficzną: ");
        location.setLatitude(scanner.nextDouble());
        System.out.println("Podaj długość geograficzną: ");
        location.setLongitude(scanner.nextDouble());
        localizations.add(location);
        System.out.println("DODANO LOKALIZACJĘ DO BAZY");
    }

    public void showAllLocations() {
        System.out.println("WSZYSTKIE ZAPISANE LOKALIZACJE");
        for (Localization localization : localizations) {
            System.out.println(localization);
        }
    }


}

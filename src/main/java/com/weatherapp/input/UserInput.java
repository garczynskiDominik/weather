package com.weatherapp.input;

import com.weatherapp.model.Localization;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    public void inputNewLocation(List<Localization> localizations) {
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

}

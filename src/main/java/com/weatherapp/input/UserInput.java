package com.weatherapp.input;

import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.Localization;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public void inputNewLocation(List<Localization> localizations) {
        Localization location = new Localization();
        System.out.println("DODAWANIE NOWEJ LOKALIZACJI");
        System.out.println("Podaj kraj: ");
        location.setCountry(scanner.nextLine());
        System.out.println("Podaj region: ");
        location.setCountry(scanner.nextLine());
        System.out.println("Podaj miejscowosc: ");
        location.setName(scanner.nextLine());
        System.out.println("Podaj szerokość geograficzną: ");
        location.setLatitude(scanner.nextDouble());
        System.out.println("Podaj długość geograficzną: ");
        location.setLongitude(scanner.nextDouble());
        localizations.add(location);
        System.out.println("DODANO LOKALIZACJĘ DO BAZY");
    }

    public void inputLocationName(List<Localization> localizations) {
        System.out.println("WYSZUKIWANIE LOKALIZACJI PO NAZWIE MIEJSCOWOŚCI");
        System.out.print("Podaj nazwę miejscowości: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        for (Localization localization : localizations) {
            if(name.equals(localization.getName())) {
                System.out.println(localization);
            }
            else {
                System.out.println("NIE MA TAKIEJ MIEJSCOWOŚCI");
            }
        }

    }

}

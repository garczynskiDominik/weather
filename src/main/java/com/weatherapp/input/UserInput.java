package com.weatherapp.input;

import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.Localization;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public void inputNewLocation(List<Localization> localizations) {
        Localization location = new Localization();
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();
        System.out.println("=========== DODAWANIE NOWEJ LOKALIZACJI ===========");
        System.out.print("Podaj kraj: ");
        location.setCountry(validatorToLocalization.stringValidator(scanner.nextLine()));
        System.out.print("Podaj region: ");
        location.setRegion(scanner.nextLine());
        System.out.print("Podaj miejscowosc: ");
        location.setName(validatorToLocalization.stringValidator(scanner.nextLine()));
        System.out.print("Podaj szerokość geograficzną: ");
        location.setLatitude(validatorToLocalization.latiValidator(scanner.nextDouble()));
        System.out.print("Podaj długość geograficzną: ");
        location.setLongitude(validatorToLocalization.longValidator(scanner.nextDouble()));
        localizations.add(location);
        System.out.println("=========== DODANO LOKALIZACJĘ DO BAZY ===========");
    }

    public void inputLocationName(List<Localization> localizations) {
        System.out.println("=========== WYSZUKIWANIE LOKALIZACJI PO NAZWIE MIEJSCOWOŚCI ===========");
        System.out.print("Podaj nazwę miejscowości: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        for (Localization localization : localizations) {
            if(name.equals(localization.getName())) {
                System.out.println(localization);
            }
            else {
                System.out.println("!!! NIE MA TAKIEJ MIEJSCOWOŚCI !!!");
            }
        }
    }

    public void inputUpdateLocation(List<Localization> localizations) {
        System.out.println("=========== AKTUALIZACJA LOKALIZACJI ===========");
        System.out.print("Podaj id lokalizacji, którą chcesz aktualizować: ");
        int id = scanner.nextInt() - 1;
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();
        System.out.print("Podaj kraj: ");
        scanner.nextLine();
        localizations.get(id).setCountry(validatorToLocalization.stringValidator(scanner.nextLine()));
        System.out.print("Podaj region: ");
        localizations.get(id).setRegion(scanner.nextLine());
        System.out.print("Podaj miejscowosc: ");
        localizations.get(id).setName(validatorToLocalization.stringValidator(scanner.nextLine()));
        System.out.print("Podaj szerokość geograficzną: ");
        localizations.get(id).setLatitude(validatorToLocalization.latiValidator(scanner.nextDouble()));
        System.out.print("Podaj długość geograficzną: ");
        localizations.get(id).setLongitude(validatorToLocalization.longValidator(scanner.nextDouble()));
        System.out.println("=========== POMYŚLNIE ZAKTUALIZOWANO ===========");
    }

}

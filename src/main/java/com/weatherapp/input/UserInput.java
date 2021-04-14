package com.weatherapp.input;

import com.weatherapp.connection.HttpClientToSendRequest;
import com.weatherapp.model.Localization;
import com.weatherapp.connection.MapperJsonToWeather;

import java.util.List;
import java.util.Scanner;

public class UserInput {


    ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();

    public void inputNewLocation(List<Localization> localizations) {
        Scanner scanner = new Scanner(System.in);
        Localization location = new Localization();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== WYSZUKIWANIE LOKALIZACJI PO NAZWIE MIEJSCOWOŚCI ===========");
        System.out.print("Podaj nazwę miejscowości: ");
        String name = scanner.nextLine();
        for (Localization localization : localizations) {
            if (name.equals(localization.getName())) {
                System.out.println(localization);
            } else {
                System.out.println("!!! NIE MA TAKIEJ MIEJSCOWOŚCI !!!");
            }
        }
    }

    public void inputUpdateLocation(List<Localization> localizations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== AKTUALIZACJA LOKALIZACJI ===========");
        System.out.print("Podaj id lokalizacji, którą chcesz aktualizować: ");
        int id = scanner.nextInt() - 1;
        validatorToLocalization.indexOfArrayValidator(localizations, id);
        try {
            System.out.println("Edycja lokalizacji " + localizations.get(id).getName());
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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!!! Przekroczono zakres listy lub lista jest pusta !!!");
        }
    }

    public void inputLocationIndexForecast(List<Localization> localizations) {
        Scanner scanner = new Scanner(System.in);
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();
        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        System.out.print("Podaj id lokalizacji: ");
        try {
            int id = validatorToLocalization.indexOfArrayValidator(localizations, scanner.nextInt() - 1);
            httpClientToSendRequest.jsonFromHttpRequest(localizations.get(id));
            System.out.print(localizations.get(id).getName() + ": ");
            System.out.println(mapperJsonToWeather.getWeatherObject(localizations.get(id)));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!!! Przekroczono zakres listy lub lista jest pusta !!!");
        }
    }
}

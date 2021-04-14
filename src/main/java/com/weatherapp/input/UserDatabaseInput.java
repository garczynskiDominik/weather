package com.weatherapp.input;

import com.weatherapp.connection.HttpClientToSendRequest;
import com.weatherapp.connection.MapperJsonToWeather;
import com.weatherapp.dataBaseDao.LocalizationDao;
import com.weatherapp.dataBaseDao.LocalizationDaoImpl;
import com.weatherapp.dataBaseDao.WeatherDao;
import com.weatherapp.dataBaseDao.WeatherDaoImp;
import com.weatherapp.model.Localization;
import com.weatherapp.model.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDatabaseInput {

    public static void showWeatherBasedLocation() {
        WeatherDao weatherDao = new WeatherDaoImp();
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        Scanner scanner = new Scanner(System.in);
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();
        System.out.print("Podaj id lokalizacji: ");
        long idLocalization = scanner.nextLong();

        Localization localization = new LocalizationDaoImpl().findById(idLocalization);
        httpClientToSendRequest.jsonFromHttpRequest(localization);
        Weather weather = mapperJsonToWeather.getWeatherObject(localization);
        System.out.println(weather);

        weatherDao.save(weather);
        weatherDao.saveIdLocalization(idLocalization);


        /**
         * Trzeba dodac id lokazlizacji zeby polaczyc ze soba dwie table relacja onetomeny
         */

    }

    public static void updateLocation() {
        Scanner scanner = new Scanner(System.in);
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        Localization location = new Localization();


        System.out.println("=========== AKTUALIZACJA LOKALIZACJI ===========");
        System.out.println("Podaj id lokalizacji która chcesz aktualizować");
        long id = scanner.nextLong();
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
        localizationDao.update(location, id);
        System.out.println("=========== POMYŚLNIE ZAKTUALIZOWANO ===========");

    }

    public static void findByLocationName() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        List<Localization> localizations = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== WYSZUKIWANIE LOKALIZACJI PO NAZWIE MIEJSCOWOŚCI ===========");
        System.out.print("Podaj nazwę miejscowości: ");
        String name = scanner.nextLine();
        localizations = localizationDao.findByName(name);
//        localizations.stream()
//                .forEach(System.out::println);
        for (Localization localization : localizations) {
            System.out.println(localization.getId() + ". " + localization.getName());
        }

    }

    public static void showAllLocations() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        List<Localization> localizations = localizationDao.findAll();
        System.out.println("=========== WSZYSTKIE ZAPISANE LOKALIZACJE ===========");
        System.out.println("Miejscowości");
//        localizations.stream()
//                .forEach(System.out::println);
        for (Localization localization : localizations) {
            System.out.println(localization.getId() + ". " + localization.getName());
        }
    }

    public static void addNewLocalization() {
        Scanner scanner = new Scanner(System.in);
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();
        LocalizationDao localizationDao = new LocalizationDaoImpl();
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
        localizationDao.save(location);
        System.out.println("=========== DODANO LOKALIZACJĘ DO BAZY ===========");
    }
}

package com.weatherapp.mainApp;

import com.weatherapp.dataBaseDao.LocalizationDao;
import com.weatherapp.dataBaseDao.LocalizationDaoImpl;
import com.weatherapp.input.UserInput;
import com.weatherapp.input.ValidatorToLocalization;
import com.weatherapp.connection.HttpClientToSendRequest;
import com.weatherapp.connection.MapperJsonToWeather;
import com.weatherapp.model.Localization;
import com.weatherapp.output.UserOutput;
import com.weatherapp.repository.LocationRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        LocationRepository locationRepository = new LocationRepository();

        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();


        Scanner scanner = new Scanner(System.in);

        do {
            userOutput.showMenu();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! PODANO ZŁY ZNAK !!!");
                System.out.println("=========== ZAMYKAM PROGRAM ===========");
                break;
            }


            switch (choice) {
                case 1:
                    // locationRepository.addLocation();
                    addNewLocalization();
                    break;
                case 2:
                    //locationRepository.showAllLocations();
                    showAllLocations();
                    break;
                case 3:
                    //userInput.inputLocationIndexForecast(locationRepository.localizations);
                    showWeatherBasedLocation();
                    break;
                case 4:
                    //locationRepository.updateLocation();
                    updateLocation();
                    break;
                case 5:
                    //locationRepository.findByLocationName();
                    findByLocationName();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 0:
                    System.out.println("=========== ZAMYKAM PROGRAM ===========");
                    break;
                default:
                    System.out.println("!!! PODANO ZŁĄ LICZBĘ !!!");
            }

        } while (choice != 0);
    }

    private static void showWeatherBasedLocation() {

        Scanner scanner = new Scanner(System.in);
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();
        System.out.print("Podaj id lokalizacji: ");

        Localization localization = new LocalizationDaoImpl().findById(scanner.nextLong());
        httpClientToSendRequest.jsonFromHttpRequest(localization);
        System.out.println(new MapperJsonToWeather().getWeatherObject(localization));

    }

    private static void updateLocation() {
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

    private static void findByLocationName() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        List<Localization> localizations = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== WYSZUKIWANIE LOKALIZACJI PO NAZWIE MIEJSCOWOŚCI ===========");
        System.out.print("Podaj nazwę miejscowości: ");
        String name = scanner.nextLine();
        localizations = localizationDao.findByName(name);
        localizations.stream()
                .forEach(System.out::println);


        /**
         * ten sam temat co w wyswietlaniu lokalizacji
         */

    }

    private static void showAllLocations() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        List<Localization> localizations = localizationDao.findAll();
        System.out.println("=========== WSZYSTKIE ZAPISANE LOKALIZACJE ===========");
        System.out.println("Miejscowości");
        localizations.stream()
                .forEach(System.out::println);

        /**
         * trzeba przerobic zeby wyswietlalo tylko nazwe miejscowosci?
         * Ew. liste zamienic na seta zeby nie powtarzały sie miejscowości ale
         * nie wiem wtedy co z indeksami
         */}

    private static void addNewLocalization() {
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

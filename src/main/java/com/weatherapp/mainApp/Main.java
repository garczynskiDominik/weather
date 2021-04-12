package com.weatherapp.mainApp;

import com.weatherapp.input.ValidatorToLocalization;
import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.MapperJsonToWeather;
import com.weatherapp.repository.LocationRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        LocationRepository locationRepository = new LocationRepository();
        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();

        Scanner scanner = new Scanner(System.in);

        do {

            showMenu();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! PODANO ZŁY ZNAK !!!");
                System.out.println("=========== ZAMYKAM PROGRAM ===========");
                break;
            }


            switch (choice) {
                case 1:
                    locationRepository.addLocation();
                    break;
                case 2:
                    locationRepository.showAllLocations();
                    break;
                case 3:
                    System.out.print("Podaj id lokalizacji: ");
                    int index = validatorToLocalization.indexOfArrayValidator(locationRepository.localizations, (scanner.nextInt() - 1));
                    httpClientToSendRequest.jsonFromHttpRequest(locationRepository.localizations.get(index));
                    System.out.print(locationRepository.localizations.get(index).getName() + ": ");
                    System.out.println(mapperJsonToWeather.getWeatherObject(locationRepository.localizations.get(index)));
                    break;
                case 4:
                    locationRepository.updateLocation();
                    break;
                case 5:
                    locationRepository.findByLocationName();
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

    public static void showMenu() {
        System.out.println("=========== MENU PROGRAMU POGODYNKA ===========");
        System.out.println("[1] Dodaj lokalizację do bazy danych");
        System.out.println("[2] Wyświetl dodane lokalizacje");
        System.out.println("[3] Wyświetl wartości pogodowe dla miejscosości o podanym indeksie");
        System.out.println("[4] Aktualizacja lokalizacji");
        System.out.println("[5] Wyszukaj lokalizacje po nazwie");
        System.out.println("[6] Dane statystyczne");
        System.out.println("[7] Zapis danych");
        System.out.println("[8] Odczyt danych");
        System.out.println("[0] WYJŚCIE");
        System.out.print("Wybór: ");
    }

}

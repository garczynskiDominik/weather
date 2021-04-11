package com.weatherapp.mainApp;

import com.weatherapp.model.HttpClientToSendRequest;
import com.weatherapp.model.MapperJsonToWeather;
import com.weatherapp.repository.LocationRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        LocationRepository locationRepository = new LocationRepository();
        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();

        Scanner scanner = new Scanner(System.in);

        do {

            showMenu();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    locationRepository.addLocation();
                    break;
                case 2:
                    locationRepository.showAllLocations();
                    break;
                case 3:
                    System.out.println("Podaj index lokalizacji");
                    int index = scanner.nextInt();
                    httpClientToSendRequest.jsonFromHttpRequest(locationRepository.localizations.get(index - 1));
                    System.out.print(locationRepository.localizations.get(index - 1).getName()+": ");
                    System.out.println(mapperJsonToWeather.getWeatherObject(locationRepository.localizations.get(index - 1)));
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("[1] Dodaj lokalizację do bazy danych");
        System.out.println("[2] Wyświetl dodane lokalizacje");
        System.out.println("[3] Wyświetl wartości pogodowe dla miejscosości o podanym indeksie");
        System.out.println("[4] Edytuj lokalizacje");
        System.out.println("[5] Wyszukaj lokalizacje po nazwie");
        System.out.println("[6] Dane statystyczne");
        System.out.println("[7] Zapis danych");
        System.out.println("[8] Odczyt danych");
        System.out.println("[0] WYJŚCIE");
    }

}

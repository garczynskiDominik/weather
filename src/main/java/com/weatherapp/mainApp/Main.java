package com.weatherapp.mainApp;

import com.weatherapp.model.MapperJsonToWeather;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("[1] Dodaj lokalizację do bazy danych");
            System.out.println("[2] Wyświetl dodane lokalizacje");
            System.out.println("[3] Wyświetl wartości pogodowe");
            System.out.println("[4] Edytuj lokalizacje");
            System.out.println("[5] Wyszukaj lokalizacje po nazwie");
            System.out.println("[6] Dane statystyczne");
            System.out.println("[7] Zapis danych");
            System.out.println("[8] Odczyt danych");
            System.out.println("[0] WYJŚCIE");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
                    System.out.println(mapperJsonToWeather.getWeatherObject());
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
}

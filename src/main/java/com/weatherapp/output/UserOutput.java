package com.weatherapp.output;

import com.weatherapp.model.Localization;

import java.util.List;

public class UserOutput {

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

    public static void outputAllLocations(List<Localization> localizations) {
        System.out.println("=========== WSZYSTKIE ZAPISANE LOKALIZACJE ===========");
        for (Localization localization : localizations) {
            System.out.println(localization);
        }
    }

}

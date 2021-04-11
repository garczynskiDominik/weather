package com.weatherapp.input;

import java.util.Scanner;

public class ValidatorToLocalization {
    public Double longValidator(double longitude) {
        boolean isCorrect = true;
        while (isCorrect) {
            if (longitude > -180 && longitude < 180) {
                return longitude;
            }
            System.out.println("Podałeś zle współrzedne, podaj poprawną długość");
            Scanner scanner = new Scanner(System.in);
            longitude = scanner.nextDouble();
        }
        return null;
    }

    public Double latiValidator(double latitude) {
        boolean isCorrect = true;
        while (isCorrect) {
            if (latitude > -90 && latitude < 90) {
                return latitude;
            }
            System.out.println("Podałeś zle współrzedne, podaj poprawną szerokość");
            Scanner scanner = new Scanner(System.in);
            latitude = scanner.nextDouble();
        }
        return null;
    }

    public String stringValidator(String name) {
        boolean isCorrect = true;
        while (isCorrect) {
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Podałeś pustą nazme, podaj właściwą nazwe");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
        }
        return null;
    }


}

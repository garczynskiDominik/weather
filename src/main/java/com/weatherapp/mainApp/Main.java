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

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        LocationRepository locationRepository = new LocationRepository();
        MapperJsonToWeather mapperJsonToWeather = new MapperJsonToWeather();
        HttpClientToSendRequest httpClientToSendRequest = new HttpClientToSendRequest();
        ValidatorToLocalization validatorToLocalization = new ValidatorToLocalization();
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
                    locationRepository.addLocation();

                    LocalizationDao localizationDao = new LocalizationDaoImpl();
                    Localization localization = new Localization();


                    localization.setCountry("Poland");
                    localization.setName("Lublin");
                    localization.setLatitude(56);
                    localization.setLongitude(34);

                    localizationDao.save(localization);


                    break;
                case 2:
                    locationRepository.showAllLocations();
                    break;
                case 3:
                    userInput.inputLocationIndexForecast(locationRepository.localizations);
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


}

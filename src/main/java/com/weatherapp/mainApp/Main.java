package com.weatherapp.mainApp;

import com.weatherapp.dataBaseDao.LocalizationDao;
import com.weatherapp.dataBaseDao.LocalizationDaoImpl;
import com.weatherapp.dataBaseDao.WeatherDaoImp;
import com.weatherapp.input.UserDatabaseInput;
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
        UserDatabaseInput userDatabaseInput = new UserDatabaseInput();


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
                    userDatabaseInput.addNewLocalization();
                    break;
                case 2:
                    //locationRepository.showAllLocations();
                    userDatabaseInput.showAllLocations();
                    break;
                case 3:
                    //userInput.inputLocationIndexForecast(locationRepository.localizations);
                    userDatabaseInput.showWeatherBasedLocation();
                    break;
                case 4:
                    //locationRepository.updateLocation();
                    userDatabaseInput.updateLocation();
                    break;
                case 5:
                    //locationRepository.findByLocationName();
                    userDatabaseInput.findByLocationName();
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

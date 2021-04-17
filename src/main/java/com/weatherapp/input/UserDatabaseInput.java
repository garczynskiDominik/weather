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
import java.util.OptionalDouble;
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
        List<Localization> ids = localizationDao.findAll();

        boolean answer = true;
        do {
            for (Localization localization : ids) {
                if (localization.getId() == idLocalization) {
                    answer = false;
                    break;
                }
            }
            if (answer) {
                answer = true;
                System.out.println("Nie ma lokalizacji o podanym id, podaj poprawne id");
                idLocalization = scanner.nextLong();
            }
        } while (answer);

        Localization localization = localizationDao.findById(idLocalization);
        httpClientToSendRequest.jsonFromHttpRequest(localization);
        Weather weather = mapperJsonToWeather.getWeatherObject(localization);
        System.out.println(weather);

        weatherDao.save(weather);
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
        localizations.stream()
                .forEach(x -> System.out.println(x.getId() + ". " + x.getName()));

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
        String name = validatorToLocalization.stringValidator(scanner.nextLine());

        List<Localization> localizations = localizationDao.findAll();
        boolean answer = false;
        do {
            for (Localization localization : localizations) {
                if (localization.getName().equals(name)) {
                    System.out.println("Podana miejscowosc jest już na liscie, podaj nową miejscowość");
                    answer = true;
                    name = validatorToLocalization.stringValidator(scanner.nextLine());
                    break;
                } else
                    answer = false;
            }
        } while (answer);
        location.setName(name);

        System.out.print("Podaj szerokość geograficzną: ");
        location.setLatitude(validatorToLocalization
                .latiValidator(scanner.nextDouble()));
        System.out.print("Podaj długość geograficzną: ");
        location.setLongitude(validatorToLocalization.longValidator(scanner.nextDouble()));
        localizationDao.save(location);
        System.out.println("=========== DODANO LOKALIZACJĘ DO BAZY ===========");
    }

    public void showStatsFromLocation() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        WeatherDao weatherDao = new WeatherDaoImp();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj id lokalizacji: ");
        long idLocalization = scanner.nextLong();

        List<Weather> weathers = weatherDao
                .getAllWeathersByLocalization(localizationDao.findById(idLocalization));
        OptionalDouble averageTemperature = weathers.stream()
                .mapToDouble(Weather::getTemperature)
                .average();
        OptionalDouble averagePressure = weathers.stream()
                .mapToDouble(Weather::getPressure)
                .average();
        OptionalDouble averageHumidity = weathers.stream()
                .mapToDouble(Weather::getHumidity)
                .average();
        OptionalDouble averageWindSpeed = weathers.stream()
                .mapToDouble(Weather::getWindSpeed)
                .average();
        String averageInfo = new StringBuilder("średnia temperatura = ")
                .append(averageTemperature.getAsDouble())
                .append("\u00B0 ")
                .append(" C ")
                .append(", średnie ciśnienie = ")
                .append(averagePressure.getAsDouble())
                .append("hPa")
                .append(", średnia wilgotność = ")
                .append(averageHumidity.getAsDouble())
                .append("%")
                .append(", średnia prędkość wiatru = ")
                .append(averageWindSpeed.getAsDouble())
                .append("km/h")
                .toString();
        System.out.println(averageInfo);


    }
}

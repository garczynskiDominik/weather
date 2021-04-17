package com.weatherapp.dataBaseDao;

import com.weatherapp.model.Localization;
import com.weatherapp.model.Weather;

import java.util.List;

public interface WeatherDao {
    void save(Weather weather);
    List<Weather> getAllWeathersByLocalization(Localization localization);


}

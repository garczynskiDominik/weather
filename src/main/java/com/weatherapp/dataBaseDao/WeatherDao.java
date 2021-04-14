package com.weatherapp.dataBaseDao;

import com.weatherapp.model.Localization;
import com.weatherapp.model.Weather;

public interface WeatherDao {
    void save(Weather weather);
    void saveIdLocalization(long id);

}

package com.weatherapp.dataBaseDao;

import com.weatherapp.model.Localization;

import java.util.List;

public interface LocalizationDao {

    void save(Localization localization);

    List<Localization> findAll();

    Localization findById(long id);

    void update(long id, double newLatitude, double newLongitude);

    void deleteById(long id);

}

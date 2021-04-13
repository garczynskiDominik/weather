package com.weatherapp.dataBaseDao;

import com.weatherapp.model.Localization;
import java.util.List;

public interface LocalizationDao {

    void save(Localization localization);

    List<Localization> findAll();

    Localization findById(long id);

    void update(Localization localization, long id);

    void deleteById(long id);

   List<Localization>findByName(String name);

}

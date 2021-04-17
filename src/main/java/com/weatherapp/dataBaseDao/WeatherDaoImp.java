package com.weatherapp.dataBaseDao;

import com.weatherapp.connection.HibernateUtils;
import com.weatherapp.model.Localization;
import com.weatherapp.model.Weather;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class WeatherDaoImp implements WeatherDao {
    @Override
    public void save(Weather weather) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(weather);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Weather> getAllWeathersByLocalization(Localization localization) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        List<Weather> weathers = session
                .createQuery("from Weather where localization=:localization")
                .setParameter("localization", localization)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        return weathers;
    }
}

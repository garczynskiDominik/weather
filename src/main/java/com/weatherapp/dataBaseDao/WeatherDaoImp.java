package com.weatherapp.dataBaseDao;

import com.weatherapp.connection.HibernateUtils;
import com.weatherapp.model.Weather;
import org.hibernate.Hibernate;
import org.hibernate.Session;

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
}

package com.weatherapp.dataBaseDao;

import com.weatherapp.connection.HibernateUtils;
import com.weatherapp.model.Weather;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public void saveIdLocalization(long id) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();


        String queryDataBase = new StringBuilder("update weather set localization_id=")
                .append(id)
                .append(" where id=")
                .append(id)
                .toString();
        Query query = session.createNativeQuery(queryDataBase);
//        Query query = session.createQuery("update Weather set localization_id=:idLocalization where id=:id")
//                .setParameter("idLocalization", id)
//                .setParameter("id", id);


        int a = query.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }
}

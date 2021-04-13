package com.weatherapp.dataBaseDao;

import com.weatherapp.connection.HibernateUtils;
import com.weatherapp.model.Localization;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class LocalizationDaoImpl implements LocalizationDao {
    @Override
    public void save(Localization localization) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .openSession();

        session.beginTransaction();
        session.saveOrUpdate(localization);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Localization> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Localization");
        List<Localization> localizations = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return localizations;
    }

    @Override
    public Localization findById(long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Optional<Localization> localization = session
                .createQuery("from Localization where id=:id")
                .setParameter("id", id)
                .uniqueResultOptional();

        session.getTransaction().commit();
        session.close();

        return localization.orElse(null);
    }

    @Override
    public void update(long id, double newLatitude, double newLongitude) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("update Localization set latitude=:newLatitude and set longitud=:newLongitude where id=:id")
                .setParameter("newLatitude", newLatitude)
                .setParameter("newLongitude", newLongitude)
                .setParameter("id", id);

        int a = query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Localization localization = (Localization) session
                .createQuery("from Localization where id=:id")
                .setParameter("id", id)
                .getSingleResult();

        session.delete(localization);
        session.getTransaction().commit();
        session.close();
    }
}

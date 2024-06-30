package service;

import config.*;
import model.*;
import org.hibernate.*;

public class PlanetService {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public String save(Planet planet){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
        return planet.getId();
    }

    public Planet findById(Long id){
        try (Session session = sessionFactory.openSession()){
            return session.find(Planet.class, id);
        }
    }

    public void delete(Planet planet){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }

    public void update(Long id, String name){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Planet foundedPlanet = session.find(Planet.class, id);
            foundedPlanet.setName(name);
            transaction.commit();
        }
    }
}

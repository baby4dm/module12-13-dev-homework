package service;

import config.*;
import model.*;
import org.hibernate.*;

public class ClientService {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public long save(Client client){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
        return client.getId();
    }

    public Client findById(Long id){
        try (Session session = sessionFactory.openSession()){
            return session.find(Client.class, id);
        }
    }

    public void delete(Client client){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }

    public void update(Long id, String name){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client foundedClient = session.find(Client.class, id);
            foundedClient.setName(name);
            transaction.commit();
        }
    }
}

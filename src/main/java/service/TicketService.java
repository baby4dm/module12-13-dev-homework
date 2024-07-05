package service;

import config.*;
import model.*;
import org.hibernate.*;

import java.sql.*;
import java.time.*;

public class TicketService {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public long save(Ticket ticket){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
        return ticket.getId();
    }

    public Ticket findById(Long id){
        try (Session session = sessionFactory.openSession()){
            return session.find(Ticket.class, id);
        }
    }

    public void delete(Ticket ticket){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }

    public void update(Long id, Client client, Planet from, Planet to){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.find(Ticket.class, id);
            ticket.setClient(client);
            ticket.setFromPlanet(from);
            ticket.setToPlanet(to);
            ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            transaction.commit();
        }
    }
}

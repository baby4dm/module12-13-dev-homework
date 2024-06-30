package config;

import lombok.*;
import model.*;
import org.flywaydb.core.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    @Getter
    private SessionFactory sessionFactory;

    static {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/homework_hibernate", "postgres", "postgres")
                .locations("db/migration")
                .load();
        flyway.migrate();
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil(){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }

    public void close(){
        sessionFactory.close();
    }
}

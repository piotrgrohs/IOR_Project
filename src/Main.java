import model.Osoba;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.GregorianCalendar;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    private static void createOsoby(){
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Osoba o1 = new Osoba("Jan", "Kowalski", "52062437366");
            session.save(o1);
            Osoba o2 = new Osoba("Tomasz", "Barański", "61091696417");
            session.save(o2);
            Osoba o3 = new Osoba("Marek", "Pyka", "63100375524");
            session.save(o1);
            Osoba o4 = new Osoba("Bartek", "Que", "71102147175");
            session.save(o2);
            tx.commit();
        }
    }
    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}
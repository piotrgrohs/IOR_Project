/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;

/* 
 @author LabHiber
 */
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);

    public static void main(String[] args) {
//        createOsoby();
//        createPracownicy();
//        showAll();
//        showAllPersons();
    }

    /**
     * Tworzy obiekty klasy Osoba, które nie są pracownikami ani dziećmi
     */
    private static void createOsoby() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Osoba o1 = new Osoba("Jan", "Kowalski", "61091696417");
            session.save(o1);
            Osoba o2 = new Osoba("Tomasz", "Barański", "61091696417");
            session.save(o2);
            tx.commit();
        }
    }

    /**
     * Tworzy obiekty testowej bazy danych
     */




    
 private static void showAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("from java.lang.Object");
            query.setComment("All objects list");
            List<Object> all = query.list();
            all.forEach(System.out::println);
        }
    }
 
 
     public static void showAllPersons(){

         try (Session session = SESSION_FACTORY.openSession()) {
            Query<Tuple> query = session.createQuery("select o.imie, o.nazwisko from Osoba o", Tuple.class);
            query.setComment("All persons list");
            List<Tuple> all = query.list();
            all.forEach(new Consumer<Tuple>() {
                @Override
                public void accept(Tuple t) {
                    System.out.println(t.get(0)+" "+t.get(1));
                }
            });
        }
    }
}

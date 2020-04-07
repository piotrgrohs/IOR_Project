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
        createLekarze();
        createPracjenci();
//        showAll();
//        showAllPersons();
    }

    /**
     * Tworzy obiekty klasy Osoba, które nie są pracownikami ani dziećmi
     */
    private static void createPracjenci() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Pacjent p1 = new Pacjent("Jan", "Kowalski", "61091696417");
            Pacjent p2 = new Pacjent("Tomasz", "Barański", "61091696417");
            Pacjent p3 = new Pacjent("Jarosłąw", "Gerd", "61099696417");
            Pacjent p4 = new Pacjent("Tomasz", "Byrański", "31091696417");

            p1.setNrKartyUbezp();
            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);
            tx.commit();
        }
    }

    /**
     * Tworzy obiekty testowej bazy danych
     */
    private static void createLekarze() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();

            Lekarz l1 = new Lekarz("Remigiusz", "Wiśniewski", "54031384974");
            Lekarz l2 = new Lekarz("Kajetan", "Witkowski", "45041641597" );
            Lekarz l3 = new Lekarz("Aleksy", "Nowak", "48072236747" );
            Lekarz l4 = new Lekarz("Dorian", "Chmielewski", "99030828113" );
            Lekarz l5 = new Lekarz("Artur", "Jankowski", "69121941168" );
            Lekarz l6 = new Lekarz("Natan", "Woźniak", "56080891962" );
            Lekarz l7 = new Lekarz("Henryk", "Wasilewska", "59111574377" );
            Lekarz l8 = new Lekarz("Gustaw", "Szewczyk", "89122951335" );
            Lekarz l9 = new Lekarz("Paweł", "Szczepański", "78102544643" );
            Lekarz l10 = new Lekarz("Bronisław", "Kucharski", "50041576666" );

            l1.setSpecjalizacja("ipsum");
            l2.setSpecjalizacja("dolor");
            l3.setSpecjalizacja("sit");
            l4.setSpecjalizacja("amet");
            l5.setSpecjalizacja("consectetur");
            l6.setSpecjalizacja("adipiscing");
            l7.setSpecjalizacja("elit");.
            l8.setSpecjalizacja("Duis");
            l9.setSpecjalizacja("porta");,
            l10.setSpecjalizacja("risus");

            l1.setTytulNauk("Dr");
            l2.setTytulNauk("Dr");
            l3.setTytulNauk("Dr");
            l4.setTytulNauk("Dr");
            l5.setTytulNauk("Dr");
            l6.setTytulNauk("Dr");
            l7.setTytulNauk("Dr");
            l8.setTytulNauk("Dr");
            l9.setTytulNauk("Dr");
            l10.setTytulNauk("Dr");

            session.save(l1);
            session.save(l2);
            session.save(l3);
            session.save(l4);
            session.save(l5);
            session.save(l6);
            session.save(l7);
            session.save(l8);
            session.save(l9);
            session.save(l10);
            tx.commit();
        }
    }



    
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

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
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;

/* 
 @author LabHiber
 */
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);

    public static void main(String[] args) {
        create();
//        showAll();
        showAllPersons();
    }


    /**
     * Tworzy obiekty testowej bazy danych
     */
    private static void create() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();

            Zabieg z1 = new Zabieg("1LG","Wielki trzonowiec");

            Usluga u1 = new Usluga(2.2, "Gastroskopia", 1.1);
            Usluga u2 = new Usluga(3.2, "Ipsum", 1.1);
            Usluga u3 = new Usluga(4.2, "Dolores", 1.3);
            Usluga u4 = new Usluga(5.2, "Du", 1.4);
            Usluga u5 = new Usluga(6.2, "Pak", 1.5);

            //Create Pacjencie
            Adres a1 = new Adres("4859HF","Latrobe",	"129-1937 Dictum. St",60,6);
            Adres a2 = new Adres("1485LT","Opelousas",	"Ap #858-6930 Ipsum. Av",14,7);
            Adres a3 = new Adres("3189CE","Chico",	"P.O. Box 150, 3996 Donec ",35,7);
            Adres a4 = new Adres("7735HV","Glen", "Cove	P.O. Box 604, 8676 Suspendisse St",83,7);

            Pacjent p1 = new Pacjent("Jan", "Kowalski", "61091696417");
            Pacjent p2 = new Pacjent("Tomasz", "Barański", "61091696417");
            Pacjent p3 = new Pacjent("Jarosłąw", "Gerd", "61099696417");
            Pacjent p4 = new Pacjent("Tomasz", "Byrański", "31091696417");

            p1.setNrKartyUbezp("1234567890");
            p2.setNrKartyUbezp("1234567290");
            p3.setNrKartyUbezp("1234563890");
            p4.setNrKartyUbezp("1234467890");


            //Create Lekarze
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


            Cennik c1 = new Cennik("122","Trzy zabiegi");
            Cennik c2 = new Cennik("222","Wiele zabiegow");
            Cennik c3 = new Cennik("221","Jedno wyrywanie");

            //Create usluga
            Wizyta w1 = new Wizyta();
            w1.setTyp("Plombowanie");
            Date date = new Date();
            w1.setData(new Timestamp(date.getTime()));
            w1.setCennik(c1);
            w1.setLekarz(l1);
            w1.setPacjent(p1);
            session.save(w1);

            Wizyta w2 = new Wizyta();
            w2.setTyp("Wybielanie");
            w2.setData(new Timestamp(date.getTime()));
            w2.setCennik(c1);
            w2.setLekarz(l1);
            w2.setPacjent(p1);
            session.save(w2);

            Wizyta w3 = new Wizyta();
            w3.setTyp("Wyrywanie zeba");
            w3.setData(new Timestamp(date.getTime()));
            w3.setCennik(c1);
            w3.setLekarz(l2);
            w3.setPacjent(p2);
            session.save(w3);

            HashSet<Wizyta> wiz1 = new HashSet<>(2);
            wiz1.add(w1);
            wiz1.add(w2);
            l1.setWizyta(wiz1);
            p1.setWizyta(wiz1);

            HashSet<Wizyta> wiz2 = new HashSet<>(1);
            wiz2.add(w3);
            l2.setWizyta(wiz2);
            p2.setWizyta(wiz2);



            l1.setSpecjalizacja("ipsum");
            l2.setSpecjalizacja("dolor");
            l3.setSpecjalizacja("sit");
            l4.setSpecjalizacja("amet");
            l5.setSpecjalizacja("consectetur");
            l6.setSpecjalizacja("adipiscing");
            l7.setSpecjalizacja("elit");
            l8.setSpecjalizacja("Duis");
            l9.setSpecjalizacja("porta");
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

            p1.setAdres(a1);
            p2.setAdres(a2);
            p3.setAdres(a3);
            p4.setAdres(a4);

            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);

            session.save(z1);
            session.save(u1);
            session.save(u2);
            session.save(u4);
            session.save(u5);
            session.save(u3);


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
            all.forEach(t -> System.out.println(t.get(0)+" "+t.get(1)));
        }
    }
}

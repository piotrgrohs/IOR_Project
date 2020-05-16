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
import java.util.zip.ZipEntry;

/* 
 @author LabHiber
 */

//
//https://edumeet.polsl.pl/ior_n1
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);

    public static void main(String[] args) {
        //create();
        //1# warunek +projekcja
        System.out.println("First task");
          firstTask();
        //2#  złączenie + operacja na kolekcjachq
        System.out.println("Second task");
          secondTask();
        //3# funkcja agregująca z ewentualną frazą HAVING
        System.out.println("Third task");
         thirdTask();
        //
    }
    //1
    private static void firstTask() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query<Tuple> query = session.createQuery("select l.nazwisko from Lekarz l where l.imie like 'W%'", Tuple.class);
            List<Tuple> all = query.list();
            all.forEach(t -> System.out.println(t.get(0)));
        }
    }
    //2
    private static void secondTask(){
        try (Session session = SESSION_FACTORY.openSession()) {
            Query<Tuple> query = session.createQuery("Select l.imie,w.typ from Lekarz l inner JOIN l.wizyty w where w.typ like 'Wybielanie'", Tuple.class);
            List<Tuple> all = query.list();
            all.forEach(t -> System.out.println(t.get(0)+" "+t.get(1)));
        }
    }
    //3
    private static void thirdTask(){
        try (Session session = SESSION_FACTORY.openSession()) {
            Query<Tuple> query = session.createQuery("Select max(c.kwota),c.opis from Cennik c  group by c.opis", Tuple.class);
            List<Tuple> all = query.list();
            all.forEach(t -> System.out.println(t.get(0)+" "+t.get(1)));
        }
    }


    /**
     * Tworzy obiekty testowej bazy danych
     */
    private static void create() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();

            Zabieg z1 = new Zabieg("1LG","Dziura");
            Zabieg z2 = new Zabieg("2LG","Dobry");
            Zabieg z3 = new Zabieg("3LG","Kamień");


            Usluga u1 = new Usluga(2.2, "Gastroskopia", 1.1);
            Usluga u2 = new Usluga(3.2, "Ipsum", 1.1);
            Usluga u3 = new Usluga(4.2, "Dolores", 1.3);

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

            //lekarze
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

            Cennik c1 = new Cennik("122","Trzy zabiegi");
            Cennik c2 = new Cennik("222","Wiele zabiegow");
            Cennik c3 = new Cennik("221","Jedno wyrywanie");

            //usluga
            Date date = new Date();

            Wizyta w1 = new Wizyta();
            Wizyta w2 = new Wizyta();
            Wizyta w3 = new Wizyta();

            w1.setTyp("Plombowanie");
            w2.setTyp("Wybielanie");
            w3.setTyp("Wyrywanie zeba");

            w1.setData(new Timestamp(date.getTime()));
            w2.setData(new Timestamp(date.getTime()));
            w3.setData(new Timestamp(date.getTime()));

            HashSet<Cennik> cen1 = new HashSet<>(1);
            HashSet<Cennik> cen2 = new HashSet<>(1);
            HashSet<Cennik> cen3 = new HashSet<>(1);

            cen1.add(c1);
            cen2.add(c2);
            cen3.add(c3);

            w1.setCennik(cen1);
            w2.setCennik(cen2);
            w3.setCennik(cen3);

            HashSet<Zabieg> zab1 = new HashSet<>(2);
            zab1.add(z1);
            zab1.add(z2);
            zab1.add(z3);
            w1.setZabiegi(zab1);

            HashSet<Wizyta> wiz1 = new HashSet<>(2);
            wiz1.add(w1);
            wiz1.add(w2);

            HashSet<Wizyta> wiz2 = new HashSet<>(1);
            wiz2.add(w3);

            l2.setWizyty(wiz2);
            p2.setWizyta(wiz2);

            l1.setWizyty(wiz1);
            p1.setWizyta(wiz1);

            u1.setWizyta(wiz1);
            u2.setWizyta(wiz2);

            u1.setCennik(cen1);
            u2.setCennik(cen2);

            p1.setAdres(a1);
            p2.setAdres(a2);
            p3.setAdres(a3);
            p4.setAdres(a4);

            session.save(c1);
            session.save(c2);
            session.save(c3);

            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);

            session.save(z1);
            session.save(z2);
            session.save(z3);

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

            session.save(w1);
            session.save(w2);
            session.save(w3);

            session.save(u1);
            session.save(u2);
            session.save(u3);

            tx.commit();
        }
    }



    
 private static void showAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("from java.lang.Object");
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

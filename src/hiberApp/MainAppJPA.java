/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.Cennik;
import model.Lekarz;
import model.Osoba;
import model.Wizyta;
import org.hibernate.Session;
import javax.persistence.Tuple;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

import static java.lang.System.*;


/* 
 @author LabHiber
 */
public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        //1# warunek +projekcja
        firstTask();
        //2#  złączenie + operacja na kolekcjach
        System.out.println("Second task");
        secondTask();
        //3# funkcja agregująca z ewentualną frazą HAVING
        System.out.println("Third task");
        thirdTask();
        EMBuilder.closeFactory();
        //
    }

    //select l.nazwisko from Lekarz l where l.imie like 'W%'
    public static void firstTask(){
        EntityManager em = EMBuilder.getEM();
        System.out.println("First task");
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Lekarz.class);
        Root<Lekarz> root = criteria.from(Lekarz.class);
        criteria.where(builder.like(root.get("imie"),"W%"));
        List<Lekarz> result = em.createQuery(criteria)
                .getResultList();
        result.forEach(l-> out.println(l.getNazwisko()));
        em.close();
    }
    //Select l.imie,w.typ from Lekarz l inner JOIN l.wizyty w where w.typ like 'Wybielanie'
    public static void secondTask(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createTupleQuery();
        Root<Lekarz> root = criteria.from(Lekarz.class);
        Join<Lekarz, Wizyta> wizyty = root.join("wizyty", JoinType.INNER);
        criteria.select(
                builder.tuple(root.get("imie"),
                wizyty.get("typ")));
        criteria.where(builder.like(wizyty.get("typ"), "Wybielanie"));
        List<Tuple> result = em.createQuery(criteria).getResultList();
        result.forEach((t) -> System.out.println( t.get(0) + " " + t.get(1)));
        em.close();
    }
    //Select max(c.kwota),c.opis from Cennik c  group by c.opis
    public static void thirdTask(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createTupleQuery();
        Root<Lekarz> root = criteria.from(Cennik.class);
        criteria.select(
                builder.tuple(root.get("opis"),
                builder.max(root.get("kwota"))));
        criteria.groupBy(root.get("opis"));
        List<Tuple> result = em.createQuery(criteria).getResultList();
        result.forEach((t) -> System.out.println( t.get(0) + " " + t.get(1)));
        em.close();
    }
  
}

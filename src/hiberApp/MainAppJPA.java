/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.Lekarz;
import model.Osoba;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static java.lang.System.*;


/* 
 @author LabHiber
 */
public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        firstTask();

    }
    //1# warunek +projekcja
    //2#  złączenie + operacja na kolekcjach
    //secondTask();
    //3# funkcja agregująca z ewentualną frazą HAVING
    //thirdTask();
    //

    public static void firstTask(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Lekarz.class);
        Root<Lekarz> root = criteria.from(Lekarz.class);
        criteria.where(builder.like(root.get("imie"),"W%"));
        List<Lekarz> result = em.createQuery(criteria)
                .getResultList();
        result.forEach(l-> out.println(l.getNazwisko()));
        em.close();
        EMBuilder.closeFactory();
    }
    public static void secondTask(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Lekarz.class);
        Root<Lekarz> root = criteria.from(Lekarz.class);
        criteria.select(root);
        List<Lekarz> result = em.createQuery(criteria).getResultList();
        result.forEach(out::println);
        em.close();
        EMBuilder.closeFactory();
    }
    public static void thirdTask(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Lekarz.class);
        Root<Lekarz> root = criteria.from(Lekarz.class);
        criteria.select(root);
        List<Lekarz> result = em.createQuery(criteria).getResultList();
        result.forEach(out::println);
        em.close();
        EMBuilder.closeFactory();
    }
  
}

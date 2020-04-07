/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.Lekarz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/* 
 @author LabHiber
 */
public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        showAllEmployees();
       
    }
    public static void showAllEmployees(){
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Lekarz.class);
        Root<Lekarz> root = criteria.from(Lekarz.class);
        criteria.select(root);
        List<Lekarz> result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        em.close();
        EMBuilder.closeFactory();
    }

  
}

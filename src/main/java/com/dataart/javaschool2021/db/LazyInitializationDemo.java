package com.dataart.javaschool2021.db;

import com.dataart.javaschool2021.db.model.AuthLog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LazyInitializationDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<AuthLog> query = em.createQuery(
                "select al from AuthLog al order by al.loggedAt desc",
                AuthLog.class
        );

        List<AuthLog> resultList = query.getResultList();


        em.close();

        // TODO перенести ДО em.close(), чтобы не было исключения
        resultList.forEach(System.out::println);
    }
}

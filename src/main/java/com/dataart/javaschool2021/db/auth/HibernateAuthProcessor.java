package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.model.AuthLog;
import com.dataart.javaschool2021.db.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.List;

public class HibernateAuthProcessor implements AuthProcessor {

    @Override
    public String performLogin(String userName, String password) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<User> query = em.createQuery(
                "select u from User u where u.username=:username and u.password=:password",
                User.class
        );
        query.setParameter("username", userName);
        query.setParameter("password", password);

        List<User> resultList = query.getResultList();
        User loggedUser = resultList.isEmpty() ? null : resultList.get(0);
        System.out.format("loggedUser = %s\n", loggedUser);

        if (loggedUser != null) {
            AuthLog authLog = new AuthLog(loggedUser, ZonedDateTime.now());
            em.persist(authLog);
        }
        em.getTransaction().commit();

        return loggedUser != null ? loggedUser.getUsername() : null;
    }
}

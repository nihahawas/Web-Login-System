/*package com.wahid.front_back_end.dao;

import jakarta.persistence.*;
import com.wahid.front_back_end.model.User;

import java.util.List;

public class UserDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");

    // ================= SAVE =================
    public boolean saveUser(User user) {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(user);

            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;

        } finally {
            if (em != null) em.close();
        }
    }

    // ================= LOGIN =================
    public User getUser(String email, String password) {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            List<User> users = em.createQuery(
                            "SELECT u FROM User u WHERE u.email = :e AND u.password = :p",
                            User.class)
                    .setParameter("e", email)
                    .setParameter("p", password)
                    .getResultList();

            return users.isEmpty() ? null : users.get(0);

        } finally {
            if (em != null) em.close();
        }
    }

    // ================= GET ALL =================
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> list = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return list;
    }

    // ================= GET BY ID =================
    public User getUserById(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    // ================= UPDATE =================
    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();
        em.close();
    }
    //later updated
    public boolean emailExists(String email) {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Long count = em.createQuery(
                            "SELECT COUNT(u) FROM User u WHERE u.email = :e",
                            Long.class)
                    .setParameter("e", email)
                    .getSingleResult();

            return count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            if (em != null) em.close();
        }
    }

    // ================= DELETE =================
    public void deleteUser(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }

        em.getTransaction().commit();
        em.close();
    }
}

 */
package com.wahid.front_back_end.dao;

import com.wahid.front_back_end.model.User;
import jakarta.persistence.*;
import java.util.List;

public class UserDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");

    // ================= SAVE / REGISTER =================
    public boolean saveUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // ================= LIST ALL USERS =================
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from User", User.class).getResultList();
        } finally {
            em.close();
        }
    }

    // ================= DELETE USER =================
    public void deleteUser(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ================= GET SINGLE USER BY ID =================
    public User getUserById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    // ================= UPDATE USER =================
    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(user);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ================= LOGIN CHECK =================
    public User getUser(String email, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :pass", User.class)
                    .setParameter("email", email)
                    .setParameter("pass", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // ================= EMAIL DUPLICATE CHECK =================
    public boolean emailExists(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}
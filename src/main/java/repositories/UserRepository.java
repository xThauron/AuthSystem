package repositories;

import listeners.EntityManagerFactoryListener;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepository implements IUserRepository {
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager = EntityManagerFactoryListener.createEntityManager();
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public void update(User user) {
        entityManager = EntityManagerFactoryListener.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getList() {
        entityManager = EntityManagerFactoryListener.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> list = (List<User>)query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public User findUserByUsername(String username) {
        entityManager = EntityManagerFactoryListener.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE lower(username) = :username").setParameter("username", username.toLowerCase());
        User user = (User)query.getSingleResult();
        entityManager.close();
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        entityManager = EntityManagerFactoryListener.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE lower(email) = :email").setParameter("email", email.toLowerCase());
        User user = (User)query.getSingleResult();
        entityManager.close();
        return user;
    }

    @Override
    public boolean isUsername(String username) {
        return findUserByUsername(username) == null;
    }

    @Override
    public boolean isEmail(String email) {
        return findUserByEmail(email) == null;
    }
}

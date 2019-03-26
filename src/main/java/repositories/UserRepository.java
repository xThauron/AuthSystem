package repositories;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository implements IUserRepository {
    private EntityManager entityManager;

    @Override
    public void add(User user) {
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean isUsername(String username) {
        return false;
    }

    @Override
    public boolean isEmail(String email) {
        return false;
    }
}

package repositories;

import models.User;

import java.util.List;

public interface IUserRepository {
    void add(User user);
    void update(User user);
    List<User> getList();
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}

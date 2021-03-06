package services;

import models.User;

import java.util.List;

public interface IUserService {
    void register(User user);

    void setRole(String username, String role);

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    List<User> getList();

    boolean isUsernameExists(String username);

    boolean isCredentialsMatched(User user);

    User login(String username);
}

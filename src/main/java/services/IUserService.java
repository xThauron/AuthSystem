package services;

import models.User;

import java.util.List;

public interface IUserService {
    void register(User user);
    void setRole(String username, String role);
    User findUserByUsername(String username);
    List<User> getList();
    boolean isUsername(String username);
    boolean isEmail(String email);
}

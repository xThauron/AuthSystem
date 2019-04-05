package services;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import repositories.IUserRepository;
import repositories.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    @Override
    public void register(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setRole("User");
        userRepository.add(user);
    }

    @Override
    public void setRole(String username, String role) {
        User user = userRepository.findUserByUsername(username);
        user.setRole(role);
        userRepository.update(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }

    @Override
    public boolean isUsernameExists(String username) {
        return findUserByUsername(username) != null;
    }


    public boolean isCredentialsMatched(User user) {
        if(!isUsernameExists(user.getUsername())) return false;
        return BCrypt.checkpw(user.getPassword(), findUserByUsername(user.getUsername()).getPassword());
    }

    public User login(String username) {
        return userRepository.findUserByUsername(username);
    }
}

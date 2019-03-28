package services;

import models.User;
import org.graalvm.compiler.lir.LIRInstruction;
import repositories.IUserRepository;
import repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

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
    public boolean isUsername(String username) {
        return findUserByUsername(username) == null;
    }

    @Override
    public boolean isEmail(String email) {
        return findUserByEmail(email) == null;
    }
}

package models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import validators.UniqueUsername;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @UniqueUsername(message = "{User.username.Unique}")
    private String username;
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,32})",
            message = "{User.password.Pattern}")
    private String password;
    @Email(message = "{User.email.Pattern}")
    private String email;
    private String role;

    @Transient
    @NotEmpty(message = "{User.passwordConfirm.MatchesPassword}")
    private String passwordConfirm;

    public User() { }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String email, String password, String passwordConfirm) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @AssertTrue(message = "{User.confirmPassword.MatchesPassword}")
    public boolean isConfirmPassword() {
        return this.password.equals(this.passwordConfirm);
    }
}

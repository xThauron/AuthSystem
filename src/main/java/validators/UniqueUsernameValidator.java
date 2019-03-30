package validators;
import services.IUserService;
import services.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private IUserService userService;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {
        userService = new UserService();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.isUsername(username);
    }
}
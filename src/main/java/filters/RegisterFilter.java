package filters;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

@WebFilter("/register")
public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        if (!httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            servletRequest.getRequestDispatcher("/register").forward(servletRequest, servletResponse);
        } else if(session.getAttribute("user") != null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.sendRedirect("/");
        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User(
                servletRequest.getParameter("username"),
                servletRequest.getParameter("email"),
                servletRequest.getParameter("password"),
                servletRequest.getParameter("passwordConfirm")
        );

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if (constraintViolations.isEmpty()) {
            servletRequest.setAttribute("user", user);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setCharacterEncoding("UTF-8");
            HashMap<String, String> errors = new HashMap<>();
            for (ConstraintViolation<User> constraintViolation : constraintViolations) {
                errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            }
            servletRequest.setAttribute("errors", errors);
            servletRequest.getRequestDispatcher("/WEB-INF/register.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

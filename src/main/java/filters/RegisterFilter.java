package filters;

import models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (!httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            servletRequest.getRequestDispatcher("/register").forward(servletRequest, servletResponse);
        }

        /*
        TODO: VALIDATION
         */

        User user = new User(
                servletRequest.getParameter("username"),
                servletRequest.getParameter("email"),
                servletRequest.getParameter("password"),
                servletRequest.getParameter("passwordConfirm")
        );

        servletRequest.setAttribute("user", user);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

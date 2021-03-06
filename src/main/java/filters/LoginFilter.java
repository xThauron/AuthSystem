package filters;

import models.User;
import services.IUserService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    private IUserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        if (!httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        } else if(session.getAttribute("user") != null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.sendRedirect("/");
        }

        User user = new User(
            servletRequest.getParameter("username"),
            servletRequest.getParameter("password")
        );

        if(userService.isCredentialsMatched(user)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("loginError", "Wrong username or password!");
            servletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

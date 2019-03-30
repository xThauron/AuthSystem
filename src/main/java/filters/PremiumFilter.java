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

@WebFilter("/premium")
public class PremiumFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) httpSession.getAttribute("user");
        if(user != null && (user.getRole().equals("Premium") || user.getRole().equals("Administrator"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}

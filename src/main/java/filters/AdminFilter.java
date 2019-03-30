package filters;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null && user.getRole().equals("Administrator")) {
            if(httpServletRequest.getMethod().equalsIgnoreCase("GET")) {
                servletRequest.getRequestDispatcher("/admin").forward(servletRequest, servletResponse);
                return;
            }

            String action = servletRequest.getParameter("action");
            if(action.equals("makePremium") || action.equals("makeNonPremium")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.sendRedirect("/");
            }
        }
    }

    @Override
    public void destroy() {

    }
}

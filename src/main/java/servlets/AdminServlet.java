package servlets;

import models.User;
import services.IUserService;
import services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private IUserService userService;

    public void init(ServletConfig servletConfig) throws ServletException {
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("users", userService.getList());
        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        if(action.equals("makePremium")) {
            userService.setRole(username, "Premium");
        } else {
            userService.setRole(username , "User");
        }
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("/");
    }
}

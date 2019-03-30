    <%@ page import="models.User" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <% User user = (User)request.getSession().getAttribute("user"); %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top text-white">
        <a class="navbar-brand" href="/">Auth system</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>

        <ul class="navbar-nav mr-auto">
            <% if(user == null) { %>
        <li class="nav-item active">
        <a class="nav-link" href="../../login">Login<span class="sr-only">(obecnie)</span></a>
        </li>
        <li class="nav-item active">
        <a class="nav-link" href="../../register">Register<span class="sr-only">(obecnie)</span></a>
        </li>
            <% }
            if(user != null && (user.getRole().equals("Premium") || user.getRole().equals("Administrator"))) { %>
                <li class="nav-item">
                    <a class="nav-link" href="../../premium">Premium</a>
                </li>
            <% }
            if(user != null && user.getRole().equals("Administrator")) { %>
                <li class="nav-item">
                    <a class="nav-link" href="../../admin">Admin</a>
                </li>
            <% } %>
        </ul>

        <ul class="navbar-nav ml-auto">
            <% if(user != null) { %>
                <li class="nav-item active">
                    <a class="nav-link" href="../../profile">Logged as <%= user.getUsername() %></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../../logout">Logout</a>
                </li>
            <% } %>
        </ul>
</nav>

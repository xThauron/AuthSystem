<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout/header.jsp" %>
<% List<User> users = (List<User>)request.getAttribute("users"); %>

<div class="row">
    <h2>Users:</h2>
</div>

<div class="row mb-2">
    <div class="col-md-1">Id</div>
    <div class="col-md-4">Username</div>
    <div class="col-md-4">Role</div>
</div>
<% for (User u : users) { %>
<form action="admin" method="post">
    <input type="hidden" name="username" value="<%= u.getUsername() %>">
    <input type="hidden" name="role" value="<%= u.getRole() %>">
    <div class="row mb-2">
        <div class="col-md-1"><%= u.getId() %></div>
        <div class="col-md-4"><%= u.getUsername() %></div>
        <div class="col-md-4"><%= u.getRole() %></div>
        <% if (u.getRole().equals("User")) { %>
        <div class="col-md-3"><button type="submit" name="action" value="makePremium" class="btn btn-success btn-block">Make premium</button></div>
        <% } else if(u.getRole().equals("Premium")) { %>
        <div class="col-md-3"><button type="submit" name="action" value="makeNoPremium" class="btn btn-danger btn-block">Take premium</button></div>
        <% } %>
    </div>
</form>
<% } %>

<%@ include file="layout/footer.jsp" %>
<%@ page import="java.util.HashMap" %>
<%@ include file="layout/header.jsp" %>
<% String loginError = (String) request.getAttribute("loginError"); %>

<div class="row justify-content-center align-items-center">
    <div class="col-md-6">
        <form method="post" action="/login">
            <h2>Login</h2>
            <div class="form-group mt-4">
                <label for="username">Username</label>
                <input type="text" class="form-control" name="username" id="username"/>
            </div>
            <div class="form-group mt-4">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary" name="action" value="btnLogin">Login
                </button>
            </div>
            <%
                if (loginError != null && !loginError.isEmpty()) {
                    out.print("<span class=\"text-danger\">" + loginError + "</span>");
                }
            %>
        </form>
    </div>
</div>
<%@ include file="layout/footer.jsp" %>
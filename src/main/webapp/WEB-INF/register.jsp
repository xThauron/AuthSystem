<%@ page import="java.util.HashMap" %>
<%@ include file="layout/header.jsp" %>
<% HashMap errors = (HashMap) request.getAttribute("errors"); %>

<div class="row justify-content-center align-items-center">
    <div class="col-md-6">
        <form method="post" action="/register">
            <h2>Register</h2>
            <div class="form-group mt-4">
                <label for="username">Username</label>
                <input type="text" class="form-control" name="username" id="username"/>
                <%
                    if (errors != null && errors.containsKey("username")) {
                        out.print("<span class=\"text-danger\">" + errors.get("username") + "</span>");
                    }
                %>
            </div>
            <div class="form-group mt-4">
                <label for="email">E-mail</label>
                <input type="text" class="form-control" name="email" id="email"/>
                <%
                    if (errors != null && errors.containsKey("email")) {
                        out.print("<span class=\"text-danger\">" + errors.get("email") + "</span>");
                    }
                %>
            </div>
            <div class="form-group mt-4">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password"/>
                <%
                    if (errors != null && errors.containsKey("password")) {
                        out.print("<span class=\"text-danger\">" + errors.get("password") + "</span>");
                    }
                %>
            </div>
            <div class="form-group mt-4">
                <label for="passwordConfirm">Confirm password</label>
                <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm"/>
                <%
                    if (errors != null && errors.containsKey("passwordConfirm")) {
                        out.print("<span class=\"text-danger\">" + errors.get("passwordConfirm") + "</span>");
                    }
                %>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary" name="action" value="btnRegister">Register
                </button>
            </div>
        </form>
    </div>
</div>
<%@ include file="layout/footer.jsp" %>
<%@ include file="WEB-INF/layout/header.jsp" %>
<div class="row justify-content-center align-items-center">
            <div class="col-md-6">
                <form method="post" action="register">
                    <h2>Register</h2>
                    <div class="form-group mt-4">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username" />
                    </div>
                    <div class="form-group mt-4">
                        <label for="email">E-mail</label>
                        <input type="text" class="form-control" name="email" id="email" />
                    </div>
                    <div class="form-group mt-4">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" />
                    </div>
                    <div class="form-group mt-4">
                        <label for="passwordConfirm">Confirm password</label>
                        <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" name="action" value="btnRegister">Register
                        </button>
                    </div>
                </form>
            </div>
        </div>
<%@ include file="WEB-INF/layout/footer.jsp" %>
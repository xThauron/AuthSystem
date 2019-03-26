<html>
<head>
    <title>Rate Scheduler</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <style type="text/css">
        body {
            padding-top: 5rem;
        }
        .starter-template {
            padding: 3rem 1.5rem;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="starter-template">
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
    </div>
</div>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Login</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>

<body>

<form method="post" action="/" onsubmit="return validateCredentials()">
    <div class="container">
        <h1 class="title">Sign in</h1>
        <hr>
        <input type="text" placeholder="User Name" name="username" id="username" required>
        <input type="password" placeholder="Password" name="password" id="password" required>
        <hr>
        <div class="signin">
            <p>
                New to DreamTour?<a href="/registration">Sign up</a>.
            </p>
        </div>

        <button type="submit" class="registerbtn">Sign in</button>
    </div>

</form>
<script>
    function validateCredentials() {

        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        let success = false;

        $.ajax({
            type: "POST",
            async: false,
            url: "/login",
            data: {
                username: username,
                password: password
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 401) {
                alert("Invalid password");
            } else if (response.status === 403) {
                alert("User with this username doesn't exist. Please, sign up!")
            }
        });

        return success;
    }
</script>
</body>
</html>

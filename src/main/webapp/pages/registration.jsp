<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Registration</title>
    <link href="css/registration.css" rel="stylesheet" type="text/css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>

<body>

<form method="post" action="/" onsubmit="return validateCredentials()">
    <div class="container">
        <h1 class="title">Sign up</h1>
        <hr>
        <input type="text" placeholder="First Name" name="firstName" id="firstName" required>
        <input type="text" placeholder="Last Name" name="lastName" id="lastName" required>
        <input type="text" placeholder="User Name" name="username" id="username" required>
        <input type="password" placeholder="Password" name="password" id="password" required>
        <input type="password" placeholder="Confirm Password" name="passwordConfirm" id="passwordConfirm" required>
        <hr>
        <div class="signin">
            <p>
                Already have an account? <a href="/login">Sign in</a>.
            </p>
        </div>

        <button type="submit" class="registerbtn">Sign up</button>
    </div>

</form>
<script>
    function validateCredentials() {

        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var passwordConfirm = document.getElementById("passwordConfirm").value;

        if(password !== passwordConfirm){
            alert("Passwords don't match");
            return false;
        }

        let success = false;
        $.ajax({
            type: "POST",
            async: false,
            url: "/registration",
            data: {
                firstName: firstName,
                lastName: lastName,
                username: username,
                password: password
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 403) {
                alert("User with this username exists!");
            }
        });

        return success;
    }
</script>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>

<body>

	<form method="POST" action="/registration">
		<div class="container">
			<h1 class="title">Sign up</h1>
			<hr>
			<input type="text" placeholder="First Name" name="firstName" required> 
			<input type="text" placeholder="Last Name" name="lastName" required> 
			<input type="text" placeholder="User Name" name="username" required> 
			<input type="password" placeholder="Password" name="password" required> 
			<input type="password" placeholder="Confirm Password" name=	"passwordConfirm" required>
			<hr>
			<div class="signin">
				<p>
					Already have an account? <a href="/login">Sign in</a>.
				</p>
			</div>

			<button type="submit" class="registerbtn">Sign up</button>
		</div>

	</form>

</body>
</html>

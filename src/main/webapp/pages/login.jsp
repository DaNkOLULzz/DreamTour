<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
</head>

<body>

	<form method="POST" action="/login">
		<div class="container">
			<h1 class="title">Sign in</h1>
			<hr>
			<input type="text" placeholder="User Name" name="username" required> 
			<input type="password" placeholder="Password" name="password" required> 
			<hr>
			<div class="signin">
				<p>
					New to DreamTour?<a href="/registration">Sign up</a>.
				</p>
			</div>

			<button type="submit" class="registerbtn">Sign in</button>
		</div>

	</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Win By Luck - Sign In</title>

<!-- Bootstrap core CSS -->
<link href="static/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="static/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/style-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<div id="login-page">
		<div class="container">
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-login">
				<h2 class="form-login-heading">sign in now</h2>
				<div class="login-wrap">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<input type="text" class="form-control" placeholder="Username"
						id="username" name="username" autofocus> <br> <input
						type="password" class="form-control" placeholder="Password"
						name="password" id="password"> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" /> <label
						class="checkbox"> <span class="pull-right"> <a
							data-toggle="modal" href="login.html#myModal"> Forgot
								Password?</a>

					</span>
					</label>
					<button class="btn btn-theme btn-block" href="index.html"
						type="submit">
						<i class="fa fa-lock"></i> SIGN IN
					</button>
					<hr>

					<div class="registration">
					<c:url var="register" value="/register"></c:url>
						Don't have an account yet?<br /> <a class="" href="${register}"> Create
							an account </a>
					</div>

					<div class="login-social-link centered">
						<p>Wanna explore more !</p>
						<c:url var="home" value="/" />
						<a href="${home}" class="btn btn-twitter"> <i
							class="fa"></i> Go Home
						</a>
					</div>

				</div>

				<!-- Modal -->
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Forgot Password ?</h4>
							</div>
							<div class="modal-body">
								<p>Enter your e-mail address below to reset your password.</p>
								<input type="text" name="email" placeholder="Email"
									autocomplete="off" class="form-control placeholder-no-fix">

							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">Cancel</button>
								<button class="btn btn-theme" type="button">Submit</button>
							</div>
						</div>
					</div>
				</div>
				<!-- modal -->

			</form>

		</div>
	</div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="static/js/jquery.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript"
		src="static/js/jquery.backstretch.min.js"></script>
	<script>
		$.backstretch("static/img/login-bg.jpg", {
			speed : 500
		});
	</script>


</body>
</html>

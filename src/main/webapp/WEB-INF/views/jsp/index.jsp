<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="win, by, luck, win by luck">

<title>Win By Luck</title>
<style>
.signInForm {
	margin-top: 12px;
}

.error {
	color: red;
}

.footerBottom {
	margin-bottom: 0px;
}
</style>
<!-- Bootstrap core CSS -->
<link href="static/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="static/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="static/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="static/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="static/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/style-responsive.css" rel="stylesheet">

<script src="static/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<c:url var="home" value="/"></c:url> <!--logo start--> <a
		href="${home}" class="logo"><b class="logo">Win By Luck</b></a> <!--logo end-->
	<div class="nav notify-row" id="top_menu"></div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><security:authorize access="hasRole('ROLE_USER')">
					<c:url var="logout" value="/logout"></c:url>
					<a class="logout" href="${logout}">LOG OUT</a>
				</security:authorize> <c:url var="loginUrl" value="/login" /> <security:authorize
					access="hasRole('ROLE_ANONYMOUS')">
					<form class="form-inline signInForm" role="form"
						action="${loginUrl}" method="post">
						<c:if test="${param.error != null}">
							<c:redirect url="${login}"></c:redirect>
						</c:if>
						<div class="form-group">
							<label class="sr-only" for="exampleInputEmail2">Email
								address</label> <input type="email" name="username" class="form-control"
								id="exampleInputEmail2" placeholder="Enter email">
						</div>
						<div class="form-group">
							<label class="sr-only" for="exampleInputPassword2">Password</label>
							<input type="password" class="form-control" name="password"
								id="exampleInputPassword2" placeholder="Password">
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-theme">Sign in</button>
					</form>
				</security:authorize></li>
		</ul>
	</div>
	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<img src="static/img/ui-sam.jpg" class="img-circle" width="60">
			</p>
			<security:authorize access="hasRole('ROLE_ANONYMOUS')">
				<h5 class="centered">Hey dere !</h5>
			</security:authorize>
			<security:authorize access="hasRole('ROLE_USER')">
				<h5 class="centered">
					Hi
					<security:authentication property="principal.name" />
				</h5>
			</security:authorize>

			<li class="mt"><c:url var="home" value="/"></c:url> <a
				class="active" href="${home}"> <i class="fa fa-dashboard"></i> <span>Home</span>
			</a></li>
			<security:authorize access="hasRole('ROLE_USER')">
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-desktop"></i> <span>Profile</span>
				</a>
					<ul class="sub">
						<li><a href="general.html">View</a></li>
						<li><a href="buttons.html">Update</a></li>
					</ul></li>

				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>Luck History</span>
				</a>
					<ul class="sub">
						<li><a href="blank.html">Win</a></li>
						<li><a href="login.html">Loose</a></li>
						<li><a href="lock_screen.html">Both</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-tasks"></i> <span>Update Credentials</span>
				</a>
					<ul class="sub">
						<li><a href="form_component.html">Change Password</a></li>
						<li><a href="form_component.html">Change Email</a></li>
					</ul></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ANONYMOUS')">
				<c:url var="login" value="/login"></c:url>
				<li class="sub-menu"><a href="${login}"> <i
						class="fa fa-tasks"></i> <span>Sign In</span>
				</a></li>
			</security:authorize>
		</ul>



		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart">
		
		<h2 align="center">Here is your chance to WIN </h2>
		
		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->


		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->
		<c:if test="${isSuccess == true}">
			<script type="text/javascript">
				regSuccess();
			</script>
		</c:if>

		<div class="col-lg-3 ds">
			<!--COMPLETED ACTIONS DONUTS CHART-->
			<c:url var="register" value="/register"></c:url>
			<security:authorize access="hasRole('ROLE_ANONYMOUS')">
				<h3>Sign Up ${isSuccess }</h3>
				<br />
				<form:form action="${register}" method="post"
					commandName="registrationForm">
					<div class="form-group">
						<label class="sr-only">Name</label> <input type="text" name="name"
							class="form-control" placeholder="Enter Name">
						<form:errors path="name" cssClass="error" />
					</div>
					<div class="form-group">
						<label class="sr-only">Email </label> <input type="email"
							name="email" class="form-control" id="exampleInputEmail2"
							placeholder="Enter Email">
						<form:errors path="email" cssClass="error" />
					</div>
					<div class="form-group">
						<label class="sr-only">Contact</label> <input type="text"
							class="form-control" name="contact" placeholder="Enter Contact">
						<form:errors path="contact" cssClass="error" />
					</div>

					<button type="submit" class="btn btn-theme">Sign Up</button>
				</form:form>
				<br />
				<br />
			</security:authorize>

			<!-- USERS ONLINE SECTION -->
			<h3>Last Week Winners !</h3>
			<!-- First Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="static/img/ui-divya.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DIVYA MANIAN</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Second Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="static/img/ui-sherman.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DJ SHERMAN</a><br />
						<muted>I am Busy</muted>
					</p>
				</div>
			</div>
			<!-- Third Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="static/img/ui-danro.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DAN ROGERS</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fourth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="static/img/ui-zac.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Zac Sniders</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fifth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="static/img/ui-sam.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Marcel Newman</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
		</div>
		<!-- /col-lg-3 -->
	</div>
	<! --/row --></section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer footerBottom">
	<div class="text-center">
		2016 - Win By Luck <a href="#" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="static/js/jquery.js"></script>
	<script src="static/js/jquery-1.8.3.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="static/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="static/js/jquery.scrollTo.min.js"></script>
	<script src="static/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="static/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="static/js/common-scripts.js"></script>

	<script type="text/javascript"
		src="static/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="static/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="static/js/sparkline-chart.js"></script>
	<script src="static/js/zabuto_calendar.js"></script>
	<c:if test="${isSuccess }">
		<script type="application/javascript">
			
			
			
			

	 $(document).ready(function () {
	        var unique_id = $.gritter.add({
	            // (string | mandatory) the heading of the notification
	            title: 'Registration Successful',
	            // (string | mandatory) the text inside the notification
	            text: 'Please check your email for login credentials !',
	            // (bool | optional) if you want it to fade out on its own or just sit there
	            sticky: true,
	            // (int | optional) the time you want it to be alive for before fading out
	            time: '',
	            // (string | optional) the class name you want to apply to that specific message
	            class_name: 'my-sticky-class'
	        });

	        return false;
	        });

		
		
		
		
		</script>
	</c:if>
</body>
</html>

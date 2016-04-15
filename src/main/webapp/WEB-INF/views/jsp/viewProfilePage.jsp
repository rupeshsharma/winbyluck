<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="editProfile" value="/user/edit-profile"></c:url>
	<a href="${editProfile}">Edit Profile</a>
	<h3>View Profile</h3>
	<p>
		Name :
		<security:authentication property="principal.name" />
	</p>
	<p>
		Username :
		<security:authentication property="principal.username" />
	</p>
	<p>
		Email :
		<security:authentication property="principal.email" />
	</p>
	<p>
		Contact :
		<security:authentication property="principal.contact" />
	</p>
	<p>
		Address Line 1 :
		<security:authentication property="principal.line1" />
	</p>
	<p>
		Address Line 2 :
		<security:authentication property="principal.line2" />
	</p>
	<p>
		City :
		<security:authentication property="principal.city" />
	</p>
	<p>
		State :
		<security:authentication property="principal.state" />
	</p>
	<p>
		Pincode :
		<security:authentication property="principal.pincode" />
	</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<body>
	<c:url var="register" value="/register"></c:url>
	<div align="center">
		<form:form action="${register}" method="post"
			commandName="registrationForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Registration</h2></td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td><form:input path="name" /> <form:errors path="name"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /> <form:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Contact No:</td>
					<td><form:input path="contact" /> <form:errors path="contact"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
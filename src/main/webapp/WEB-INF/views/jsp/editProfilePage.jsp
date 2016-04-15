<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="register" value="/register"></c:url>
	<div align="center">
		<form:form action="${register}" method="post"
			commandName="userProfileForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Edit Profile</h2></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<p>
							Name :
							<security:authentication property="principal.name" />
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<p>
							Username :
							<security:authentication property="principal.username" />
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<p>
							Email :
							<security:authentication property="principal.email" />
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<p>
							Contact :
							<security:authentication property="principal.contact" />
						</p>
					</td>
				</tr>
				<tr>
					<td>Address Line 1 :</td>
					<td><form:input path="line1" /> <form:errors path="line1"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Address Line 2 :</td>
					<td><form:input path="line2" /> <form:errors path="line2"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><form:input path="city" /> <form:errors path="city"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><form:input path="state" /> <form:errors path="state"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Pincode :</td>
					<td><form:input path="pincode" /> <form:errors path="pincode"
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag form demo</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br><br>
		Last name:	<form:input path="lastName"/>
		<br><br>
		Country: 
		<!-- <form:select path="country">
			<form:option value="Da Nang" label="Da Nang"/>
			<form:option value="Da Nang" label="HN"/>
			<form:option value="Da Nang" label="HCM"/>
		</form:select>
		-->
		
		<form:select path="country">
			<form:options items="${student.countryOptions }" />
		</form:select>
		<br><br>
		Favourite language: 
		Java<form:radiobutton path="favouriteLanguage" value="java"/>
		C#<form:radiobutton path="favouriteLanguage" value="C#"/>
		Python<form:radiobutton path="favouriteLanguage" value="python"/>
		<br><br>
		<input type="submit" value="Send">
	</form:form>
</body>
</html>
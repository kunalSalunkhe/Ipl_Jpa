<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Add New Team :

	<form:form action="teamAdded" modelAttribute="team">

        Team Name : <form:input path="teamName" />

		<br>
		<br>

        Team Owner name : <form:input path="ownerName" />

		<br>
		<br>


		<input type="submit" value=" submit" />


	</form:form>


</body>
</html>
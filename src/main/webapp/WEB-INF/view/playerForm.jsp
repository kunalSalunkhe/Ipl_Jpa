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

	Add New Player :

	<form:form action="addPlayer" modelAttribute="player">

        Player Name : <form:input path="playerName" />

		<br>
		<br>

       	Type : <form:input path="type" />

		<br>
		<br>
	
		Age : <form:input path="age" />

		<br>
		<br>


		<input type="submit" value="submit" />


	</form:form>


</body>
</html>
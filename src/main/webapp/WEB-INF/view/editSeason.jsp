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

 

	Edit New Season :

	<form:form action="seasons/edit/${season.seasonId}" modelAttribute="season">
	
		Season Name : <form:input path="seasonName" />

		<br>
		<br>

		Season Year : <form:input path="yearOfSeason" />

		<br>
		<br>


		<input type="submit" value=" submit" />


	</form:form>

</body>
</html>
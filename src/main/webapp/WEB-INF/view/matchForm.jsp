<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	Add New Match :

	<form:form action="addMatch" modelAttribute="match">

        Match Date : <form:input path="matchDate" />

		<br>
		<br>

       	Venue : <form:input path="venue" />

		<br>
		<br>

		Season Name :
		
		<form:select path="season.seasonName">

			<c:forEach var="season" items="${seasonList}">
			
				<form:option value="${season.seasonName}" label="${season.seasonName}" />
				
			</c:forEach>
		</form:select>

		<br>
		<br>
		

		<br>
		<br>


		<input type="submit" value="submit" />


	</form:form>


</body>
</html>
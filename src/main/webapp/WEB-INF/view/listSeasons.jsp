<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Seasons</h3><br>
	
	<table border = "1">
		<th>Sl No</th>
		<th>Season Name</th>
		<th>Season Year</th>
		<th>Edit</th>
		<th>Delete</th>
		 
		<c:forEach var="season" items="${seasonList}">
			<tr>
				<td><c:out value="${season.seasonId}" /></td>
				<td><a href="seasons/${season.seasonId}"><c:out value="${season.seasonName}" /></a></td>
				<td><c:out value="${season.yearOfSeason}" /></td>
				<td><a href = "seasons/editForm/${season.seasonId}">Edit</a>
				<td><a href = "seasons/delete/${season.seasonId}">Delete</a>
			</tr>
			</tr>
		</c:forEach>
     <br>
	<form action="seasons/seasonForm">
		<button type="submit">Add New Season</button>
	</form>
	</table>


</body>
</html>
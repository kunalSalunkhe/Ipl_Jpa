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

	<table border="1">
		<th>Sl no</th>
		<th>Team Name</th>
		<th>Owner Name</th>
		<c:forEach var="seasonTeam" items="${seasonTeamList}">
			<tr>
				<td><c:out value="${seasonTeam.teamId}" /></td>
				<td><c:out value="${seasonTeam.teamName}" /></td>
				<td><c:out value="${seasonTeam.ownerName}" /></td>
			</tr>
		</c:forEach>
		<br>
		<form action="teams/addTeam">
			<button type="submit">Add New Team</button>
	</table>

</body>
</html>
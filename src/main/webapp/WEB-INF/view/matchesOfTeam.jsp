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
		<th>Sl. No</th>
		<th>Match Date</th>
		<th>Venue</th>
		<th>Opponent Team</th>
		<c:forEach var="teamMatch" items="${matches}">
			<tr>
				<td><c:out value="${teamMatch.m.matchId}" /></td>
				<td><c:out value="${teamMatch.m.matchDate}" /></td>
				<td><c:out value="${teamMatch.m.venue}" /></td>
				<td><c:out value="${teamMatch.t2.teamName}" /></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>
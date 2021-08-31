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
		<th>Team 1</th>
		<th>Team 2</th>
		<c:forEach var="seasonMatch" items="${seasonMatchList}">
			<tr>
				<td><c:out value="${seasonMatch.matchId}" /></td>
				<td><c:out value="${seasonMatch.matchDate}" /></td>
				<td><c:out value="${seasonMatch.venue}" /></td>
				<td><c:out value="${seasonMatch.teamsPlayingInThisMatch.t1.teamName}" /></td>
				<td><c:out value="${seasonMatch.teamsPlayingInThisMatch.t2.teamName}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
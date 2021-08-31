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
		<th>venue</th>
		<th>Runs</th>
		<th>Wickets</th>

		<th></th>
		<c:forEach var="playerMatch" items="${playerMatches}">
			<tr>
				<td><c:out value="${playerMatch.match.matchId}" /></td>
				<td><c:out value="${playerMatch.match.matchDate}" /></td>
				<td><c:out value="${playerMatch.match.venue}" /></td>
				<td><c:out value="${playerMatch.runsScored}" /></td>
				<td><c:out value="${playerMatch.wicketsTaken}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
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
		<th>Player Name</th>
		<th>Type</th>
		<c:forEach var="seasonPlayer" items="${seasonPlayerList}">
			<tr>
				<td><c:out value="${seasonPlayer.playerId}" /></td>
				<td><c:out value="${seasonPlayer.playerName}" /></td>
				<td><c:out value="${seasonPlayer.type}" /></td>

			</tr>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
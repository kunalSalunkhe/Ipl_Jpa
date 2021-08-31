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
		<th>Award Name</th>
		<th>Winner</th>
		<c:forEach var="award" items="${awards}">
			<tr>
				<td><c:out value="${award.awardId}" /></td>
				<td><c:out value="${award.awardName}" /></td>
				<td><c:out value="${award.winner.playerName}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
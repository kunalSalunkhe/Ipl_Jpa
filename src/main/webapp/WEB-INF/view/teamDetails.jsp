<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Team Informtion :
	<br>
	<br> Team ID : ${team.teamId}
	<br>
	<br> Team Name : ${team.teamName}
	<br>
	<br> Team Owner : ${team.ownerName}
	<br>
	<br>
	<form action="seasons/1/players">
		<button type="submit">Season 1 Players</button>
	</form>
	<br>
	<br>
	<form action="seasons/1/matches">
		<button type="submit">Season 1 Matches</button>
	</form>

</body>
</html>
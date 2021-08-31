
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Player Informtion :
	<br>
	<br> Player ID : ${player.playerId}
	<br>
	<br> Player Name : ${player.playerName}
	<br>
	<br> Player Type : ${player.type}
	<br>
	<br>
	<form action="awards">
		<button type="submit">Awards</button>
	</form>
	<br>
	<br>
	<form action="matches">
		<button type="submit">Matches</button>
	</form>

</body>
</html>
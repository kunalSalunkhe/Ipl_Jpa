<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Season Details :</h3>
	<br> Season ID - ${season.seasonId}
	<br> Season Name - ${season.seasonName}
	<br> Season Year - ${season.yearOfSeason}
	<br>

	<form method="get" action="${season.seasonId}/teams">
		<button type="submit">Teams</button>
	</form>
	<form method="get" action="${season.seasonId}/players">
		<button type="submit">Players</button>
	</form>
	<form method="get" action="${season.seasonId}/matches">
		<button type="submit">Matches</button>
	</form>
	<form method="get" action="${season.seasonId}/awards">
		<button type="submit">Awards</button>
	</form>

</body>
</html>
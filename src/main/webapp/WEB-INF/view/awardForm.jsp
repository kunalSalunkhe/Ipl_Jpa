<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Add New Award :

	<form:form action="addAward" modelAttribute="award">

        Award Name : <form:input path="awardName" />

		<br>
		<br>



		<input type="submit" value=" submit" />


	</form:form>

</body>
</html>
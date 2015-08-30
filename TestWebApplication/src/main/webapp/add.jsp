<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">Меню</a>
	<br />
	<a href="listPage">Посмотреть пользователей</a>
	<br />
	<br /> Введите путь к файлу:
	<br />
	<!--<input id="title" name="title">
	<a href="convert">Добавить</a>-->
	<form action="addUsers" method="POST">
		<input type="text" name="title" /> <input type="submit" name="submit"
			value="Добавить" />
	</form>
</body>
</html>
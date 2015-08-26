<%@ include file="/jsp/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th><a href="sorting_name">Имя</a></th>
			<th><a href="sorting_surname">Фамилия</a></th>
			<th><a href="sorting_login">Логин</a></th>
			<th><a href="sorting_email">E-mail</a></th>
			<th><a href="sorting_phoneNumber">Телефон</a></th>
		</tr>
		<c:forEach items="${users}" var="users">
			<tr>
				<td>${users.name}</td>
				<td>${users.surname}</td>
				<td>${users.login}</td>
				<td>${users.email}</td>
				<td>${users.phoneNumb}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="add">Добавить пользователя</a>

</body>
</html>
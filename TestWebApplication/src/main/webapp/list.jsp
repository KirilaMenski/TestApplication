<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style: none;
}

ul li {
	float: left;
}
</style>
</head>
<body>
	<a href="index.jsp">Меню</a>
	<table border="1">
		<tr>
			<th><a href="listPage?colName=id">ID</a></th>
			<th><a href="listPage?colName=name">Имя</a></th>
			<th><a href="listPage?colName=surname">Фамилия</a></th>
			<th><a href="listPage?colName=login">Логин</a></th>
			<th><a href="listPage?colName=email">E-mail</a></th>
			<th><a href="listPage?colName=phone_number">Телефон</a></th>
		</tr>
		<c:forEach items="${users}" var="users">
			<tr>
				<td><c:out value="${users.id}" /></td>
				<td><c:out value="${users.name}" /></td>
				<td><c:out value="${users.surname}" /></td>
				<td><c:out value="${users.login}" /></td>
				<td><c:out value="${users.email}" /></td>
				<td><c:out value="${users.phoneNumb}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<c:forEach items="${page}" var="page">
		<ul>
			<li>-</li>
			<li><a href="listPage?page=${page}">${page}</a></li>
		</ul>
	</c:forEach>
	<br />
	<a href="add.jsp">Добавить пользователя</a>

</body>
</html>
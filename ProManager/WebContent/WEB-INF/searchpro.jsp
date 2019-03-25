<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">球员信息管理</h1>

	<div id="all_comm" class="all">
		<h2 align="center">球员信息一览</h2>
		<table id="table_id" border="1">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>birthday</td>
				<td>team</td>
				<td>goal</td>
				<td>assist</td>
				<td>card</td>
			</tr>
			<c:forEach items="${pro}" var="pro">
				<tr>
					<td>${pro.id}</td>
					<td>${pro.name}</td>
					<td>${pro.birthday}</td>
					<td>${pro.team}</td>
					<td>${pro.goal}</td>
					<td>${pro.assist}</td>
					<td>${pro.card}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		</div>
		<form action="queryByName" method="POST">
			<input type="text" name="name"> <input type="submit"
				value="提交">
		</form>
		<br>
		<br>
		<a href = "login.jsp">返回主页</a>
</body>
</html>
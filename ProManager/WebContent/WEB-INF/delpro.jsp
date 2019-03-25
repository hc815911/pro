<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>球員管理</title>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#delprosumit").click(
				function() {
				var input_id= $("#delid").val();
				if (input_id == ""|| input_id == null) {
				alert("id不能為空！！！");
				return false;
				}else {
					alert("刪除成功！");
					$("#delForm").submit();
					return false;
				}
				})
				})





</script>
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
		<h5 id="edit_title">刪除球員</h5>
		<form id="delForm" action="delete" method="post">
		<input id="delid" type="text" placeholder="id"name="id" />
			<button id="delprosumit" type="button">
				<p>刪除球員</p>
			</button>
		</form>
		<br>
		<br>
		<a href = "login.jsp">返回主页</a>
</body>
</html>
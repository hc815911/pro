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

		$("#addprosumit").click(
				function() {
				var input_name = $("#addname").val();
				var input_birthday = $("#addbirthday").val();
				var input_team = $("#addteam").val();
				var input_goal = $("#addgoal").val();
				var input_assist = $("#addassist").val();
				var input_card = $("#addcard").val();
				if (input_name == ""|| input_name == null) {
				alert("姓名不能為空！！！");
				return false;
				} else {
				var userbirthday = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
				if (!userbirthday.test($("#addbirthday").val())) {
					alert("日期格式不正确，正确格式为：xxxx-xx-xx");
				return false;
				}else {
				if (input_team == ""|| input_team == null) {
					alert("隊伍不能爲空！！！");
				return false;
				}else {
				if (input_goal == ""|| input_goal == null) {
					alert("進球數不能爲空！！！");
				return false;
				} else {
				if (input_assist == ""|| input_assist == null) {
					alert("助攻不能爲空！！！");
				return false;
				} else {
				if (input_card == ""|| input_card == null) {
					alert("卡數不能爲空！！！");
				}else{

					alert("ok！");
					$("#addForm").submit();
					return false;

				}
				}
				}
				}
				}
				}
				})
				})

	$(function(){
	$("#addname").change(function(){
		var name= $("#addname").val();
		name = $.trim(name);
		if(name!= null && name!=""){
			var url = "checkname.do";
			var	args = {"name":name,"time":new Date()};
			$.post(url,args,function(date){
			$("#checkname").html(date);

			})
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
		<h5 id="edit_title">添加球員</h5>
		<form id="addForm" action="add" method="post">
		<input id="addname" type="text" placeholder="name"name="name" /><div id = "checkname"></div>
		<input id="addbirthday" type="text" placeholder="birthday" name="birthday" />
		<input id="addteam" type="text" placeholder="team" name="team" />
		<input id="addgoal" type="text" placeholder="goal"name="goal" />
		<input id="addassist" type="text" placeholder="assist" name="assist" />
		<input id="addcard" type="text" placeholder="card" name="card" />
			<button id="addprosumit" type="button">
				<p>添加球員</p>
			</button>
		</form>
		<br>
		<br>
		<a href = "login.jsp">返回主页</a>
</body>
</html>
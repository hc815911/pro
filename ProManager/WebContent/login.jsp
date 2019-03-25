<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">2019年度英超球员信息</h1>

	<div id="all_comm" class="all">
		<h2 align="center">2019年度英超球员信息</h2>
	</div>
	 <form action="login.do" method="post">
ユーザ名  :<input	type="text" name="username">
        <br>
パスワード:<input	type="password" name="password">
       <br>
       <input type="submit" value="ログイン">
    </form>
<br>
<br>
<a href="gotoallpage"><b><font color=blue >1.球员数据表</font></b></a>
<br>
<br>
<a href="searchpro"><b><font color=blue >1.球员数据查询</font></b></a>
<br>
<br>
<a href="addpro"><b><font color=blue >1.球员数据添加</font></b></a>
<br>
<br>
<a href="delpro"><b><font color=blue >1.球员数据刪除</font></b></a>
<br>
<br>
<a href="updatepro"><b><font color=blue >1.球员数据更新</font></b></a>
</body>
</html>
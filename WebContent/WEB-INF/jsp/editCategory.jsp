<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editCategory</title>
</head>
<body>
	<!-- 	<div style="width:500px;margin:0px auto;text-align:center"> -->
	<!-- 	<div style="text-align:center;margin-top:40px"> -->
	<!-- 		Category ID： -->
	<%-- 		<input type="text" name="id" value="${c.id }" readonly="readonly"><br> --%>
	<!-- 		Category NAME: -->
	<%-- 		<input type="text" id="name" name="name" value="${c.name }"><br> --%>
	<%-- 		<input type="button" formmethod="post" value="修改分类"  onclick="location='updateCategory?id=${c.id}&name='+document.getElementById('name').value"> --%>
	<!-- 	</div> -->
	<!-- 	</div> -->

	<div style="width: 500px; margin: 0px auto; text-align: center">
		<div style="text-align: center; margin-top: 40px">
			<form method="post" action="updateCategory">
				Category ID：
				<input type="text" name="id" value="${c.id }" readonly="readonly"><br>
				Category NAME:
				<input type="text" id="name" name="name" value="${c.name }"><br>
				<input type="submit" value="修改分类">
			</form>
		</div>
	</div>
</body>
</html>
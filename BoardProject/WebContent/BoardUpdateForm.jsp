<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정 폼</title>
<link rel="stylesheet" type="text/css" href="css/main.css">


<style type="text/css">

.layout{
	width: 500px;
	margin: 0 auto;
	margin-top: 40px;
}

input{
	width: 100%;
}

textarea {
	width: 100%;
	margin-top: 10px;
	min-height: 300px;
}



</style>

</head>

<body>


<div class="layout">
	<form action="boardupdate.action" method="post">
		<input type="text" name="bd_title" value="${brd.bd_title }">
		<textarea rows="" cols="" name="bd_content">${brd.bd_content }</textarea>
		<input type="hidden" name="bd_id" value="${brd.bd_id }">
		<button type="submit" class="btn">수정</button>
	</form>
</div>


</body>
</html>











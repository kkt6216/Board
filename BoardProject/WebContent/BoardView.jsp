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
<title>게시만 상세 페이지</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<h1>${brd.bd_title }</h1>
<img src="files/${brd.fileName }" alt="" />
<p>${brd.bd_content }</p>
<a href="/download.action?bd_id=${brd.bd_id }">다운로드</a>
<button type="button" onclick="location.href='boardupdateform.action?bd_id=${brd.bd_id}'">수정</button>
<button type="button" onclick="location.href='boarddelete.action?bd_id=${brd.bd_id}'">삭제</button>

</body>
</html>
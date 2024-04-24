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
<title>게시판 리스트</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">

.layout{
	width: 500px;
	margin: 0 auto;
	margin-top: 40px;
}

</style>


 <!-- 부트스트랩 js -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script> 
<!-- 제이쿼리 적용 JS -->
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
</head>
<body>

<!-- <div class="layout">
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>제목입니다.</td>
			</tr>
		</tbody>
	</table>
</div> -->



<div class="layout">
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="brdList" items="${brdList }">
				<tr>
					<td>${brdList.bd_id}</td>
					<td>${brdList.bd_title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>








</body>
</html>
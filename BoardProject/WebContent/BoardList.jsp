<%@page import="com.test.mvc.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	// 현재 페이지
	int num = 1;

	// 게시물 수
	int totalCount = (Integer)request.getAttribute("count"); 

	// 페이지 수 
	int totalPage = totalCount/10 + 1; 
	
	// 게시물 
	ArrayList<BoardDTO> brdList = (ArrayList<BoardDTO>) request.getAttribute("brdList");
	
	


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
	<div>
		게시물 수 : <%=totalCount %>
		페이지 수 : <%=totalPage %>
	</div>
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
					<td>
						<a href="boardview.action?bd_id=${brdList.bd_id }">${brdList.bd_title}</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a class="prev">이전</a>
		<%
		for(int i = num; i<= totalPage; i++)
		{
		%>
		<a>[<%=i %>]</a>
		<%
		}
		%>
		
		<a class="next">다음</a>
	</div>
	
</div>









</body>
</html>
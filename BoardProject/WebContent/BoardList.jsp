<%@page import="com.test.mvc.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	ArrayList<BoardDTO> brdList = (ArrayList<BoardDTO>) request.getAttribute("brdList");


	// 전체 게시물 수 
	int totalCount = (Integer) request.getAttribute("count");
	
	// 페이지당 게시물 수
	int numPerPage = 10;
	
	// 전체 페이지 수 Math.ceil(올림 함수)
	int totalPage = (int) Math.ceil((double)totalCount / numPerPage);
	
	// 현재 페이지
  	int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1; // 현재 페이지

 	// 시작 페이지 번호
  	int startPage = ((currentPage - 1) / 10) * 10 + 1;
  	
 	// 끝 페이지 번호
    int endPage = Math.min(startPage + 9, totalPage); 
  	

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">

.layout {
	width: 500px;
	margin: 0 auto;
	margin-top: 40px;
	}
	
.paging-zone{
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
				<c:forEach var="brdList" begin="<%= (currentPage - 1) * numPerPage %>" end="<%= Math.min(currentPage * numPerPage - 1, brdList.size() - 1) %>" items="${brdList}">
			    <tr>
			        <td>${brdList.bd_id}</td>
			        <td><a href="boardview.action?bd_id=${brdList.bd_id}">${brdList.bd_title}</a></td>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
	 
	
</div>

<div class="paging-zone">
    <%
        if (currentPage > 1) {
    %>
        <a href="?page=<%= currentPage - 1 %>" class="prev">이전</a>
    <%
        }
    %>
    <%
        for (int i = startPage; i <= endPage; i++) {
    %>
        <a href="?page=<%= i %>">[<%= i %>]</a>
    <%
        }
    %>
    <%
        if (currentPage < totalPage) {
    %>
        <a href="?page=<%= currentPage + 1 %>" class="next">다음</a>
    <%
        }
    %>
     
     
</div>









</body>
</html>
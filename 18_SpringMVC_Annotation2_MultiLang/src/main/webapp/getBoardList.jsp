<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 태그 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
<div align="center">
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<h3>${userName}! <spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">log-out</a></h3>
	
	<!-- 검색 파트 -->
	<form action="getBoardList.do" method="post">
	<table border="1" style="width:700;">
		<tr>
			<td align="right">
				<select name="searchCondition">  <!-- items로 map 가져오고 var로 값을 하나씩 저장 -->
					<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}
					</c:forEach>
				</select>
				<input type="text" name="searchKeyword"/>
				<input type="submit" value="<spring:message code='message.board.list.search.condition.btn'/>"/>
			</td>
		</tr>
	</table>
	</form>
	<!-- 검색 파트 종료 -->
	
	<!-- 게시글 목록 출력 -->
	<br>
	<table border="1" style="width:700;">
		<tr>
			<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
			<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
			<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
		</tr>
<!-- JSTL forEach를 통해 전달된 게시글 목록 데이터를 반복하여 읽어 출력 -->
<!-- items : 컨트롤러에서 보낸 타입 var: 받아온 데이터를 담는 변수 -->
	<c:forEach items="${boardList}" var="board">
	
	<tr>	
		<td>${board.seq}</td>
		<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.regDate}</td>
		<td>${board.cnt}</td>
	</tr>
	</c:forEach>
	
	</table>
	<!-- 게시글 목록 출력 종료-->
	<br>
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
</div>
</body>
</html>
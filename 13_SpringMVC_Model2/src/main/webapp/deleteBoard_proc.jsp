<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ezen.biz.dao.BoardDAO" %>
<%@ page import="com.ezen.biz.dto.BoardVO" %>

<%
	//1.사용자 입력 정보 추출
	String seq = request.getParameter("seq");
	
	//2.DB연동처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(vo);
	
	//3.화면 네비게이션
	response.sendRedirect("getBoardList.jsp");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
</head>
<body>
<div align="center">
	<h1><spring:message code="message.user.login.title"/></h1>
	<!-- 영어, 한글을 선택하기 위한 메뉴 -->
	<a href="login.do?lang=en"><spring:message code="message.user.login.language.en"/></a>&nbsp;&nbsp;
	<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko"/></a>
	<hr>
	<form action="login.do" method="post">
		<table border="1">
		<tr>
			<td bgcolor="orange"><spring:message code="message.user.login.id"/></td>
			<td><input type="text" name="id" valus="${user.id}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange"><spring:message code="message.user.login.password"/></td>  <!-- 타입으로 지정된 userVO를 앞 글자를 소문자로 바꿔서 값 지정 -->
			<td><input type="password" name="password" valus="${user.password}"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="<spring:message code='message.user.login.loginBtn'/>"/>
			</td>
		</tr>
		</table>
	</form>
	<hr>
</div>
</body>
</html>

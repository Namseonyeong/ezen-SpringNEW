// JSP 관련 처리 (요청을 받아서 나눠주는 역할)
package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	// import가 안되면 라이브러리에 톰캣을 포함 한시킨것임
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
	
	
	
}

//class 파일을 만들때 하단의 Interfaces에서 ADD를 눌러서 controller(com.ezen.view.controller) 추가
package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public class LoginController implements Controller {
	
	// 로그인 처리 
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		
		if (user != null) { // 로그인 성공의 경우
			 return "getBoardList.do";
		} else {
			return "login"; //.jsp를 기입안해도 리절버..? 에서 알아서 jsp를 붙여서 넘겨준다...?
		}
	}
}

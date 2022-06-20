package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public class LoginController implements Controller {
	
	// ID, PASS를 받아서 DAO에서 조회해서.. 넘겨준다..
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		// 화면 응답 처리
		ModelAndView modelView = new ModelAndView();
		
		if (user != null) { // 로그인 성공의 경우 , 화면만 넘겨주면 되기 때문에 modelView 사용 / redirect : 사용자가 요청하듯
			 modelView.setViewName("redirect:getBoardList.do");
		} else {
			 modelView.setViewName("login"); 
		}
		
		return modelView;
	}

}

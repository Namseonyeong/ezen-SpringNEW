package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Controller
public class LoginController {

	// ID, PASS를 받아서 DAO에서 조회해서.. 넘겨준다..
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDao) {

		UserVO user = userDao.getUser(vo);

		if (user != null) { // 로그인 성공의 경우 , 화면만 넘겨주면 되기 때문에 modelView 사용 / redirect : 사용자가 요청하듯
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}

package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;
import com.ezen.biz.user.UserService;

// 로그인, 로그아웃 통합
@Controller
public class MemberController {
	
	@Autowired
	private UserService userService;
	
	// 사용자 로그인 화면 출력 : method는 상수기 때문에 " " 가 안들어간다
	// @ModelAttribute : Command 객체의 이름을 지정하여 jsp 소스에서 사용하도록 함
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		

		vo.setId("user1");
		vo.setPassword("user1");
		
		return "login.jsp";
	}
	
	
	// 사용자 로그인 인증 : HttpSession 객체를 생성하여 넣어주면 자동적으로 이름...?
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDao, HttpSession session) {
		
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user = userService.getUser(vo);

		if (user != null) { // 로그인 성공의 경우 
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

	// 사용자 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();

		return "login.jsp";

	}
}

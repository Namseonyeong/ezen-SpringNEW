package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		// ๋ก๊ทธ์์
		session.invalidate();

		return "login.jsp";

	}

}

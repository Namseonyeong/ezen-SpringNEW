package com.ezen.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
	// 스프링 컨테이너 구동
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	
	// UserSerivceImpl 객체 Lookup
	UserService userService = (UserService) container.getBean("userService");
	
	UserVO user = new UserVO();
	user.setId("sslee");
	user.setPassword("1234");
	
	
	UserVO result = userService.getUser(user);
	if (result != null) {
		System.out.println("로그인에 성공하였습니다.");
	} else {
		System.out.println("로그인에 실패하였습니다");
	}
	
	// 컨테이너 종료
	container.close();
	
	}
}

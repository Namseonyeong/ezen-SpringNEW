package com.ezen.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


import com.ezen.biz.dto.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 구동.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. UserSerivceImpl 객체 Lookup
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. 로그인 기능 테스트.
		//		UserVO 객체 생성, id/password 설정
		// 		userService의 getUser() 호출
		// 		위의 호출 결과를 이용하여 로그인 성공여부 확인
			UserVO user = new UserVO();
			user.setId("sslee");
			user.setPassword("1234");
			
			UserVO result = userService.getUser(user);
			
			if (result != null) {
				System.out.println("로그인에 성공하였습니다.");
			} else {
				System.out.println("로그인에 실패하였습니다.");
			}
			
		container.close();
		}
		
		
	}


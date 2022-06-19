package com.ezen.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;


// UserService 만들때 해당 파일 오른쪽 마우스-refactor-extr..인터페이스

@Service("userService") //(2) 어노테이션 방식으로 구현시 필요 
public class UserServiceimpl implements UserService {
	@Autowired  //(3) 어노테이션 방식으로 구현시 필요 (객체 생성이 안되어있기 때문에 자동 객체 생
	private UserDAO userDAO; // 값을 가져올 객체
	

	
	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo); // UserDAO에서 받은 값을 넣는다
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	

	
}

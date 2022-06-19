package com.ezen.biz.user;


import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public interface UserService {
	public  UserVO getUser(UserVO vo);
	
	void setUserDAO(UserDAO uDao);
}

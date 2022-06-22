package com.ezen.biz.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dto.UserVO;

@Service("userDao")
public class UserDAO extends SqlSessionDaoSupport {

	/*
	 * 부모 클래스의 세션 생성 메소드를 호출하여 데이터베이스에 연결할 세션을 생성
	 */
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 사용자 인증
	public UserVO getUser(UserVO vo) {
		System.out.println("===>Mybatis로 사용자 인증 조회...");
		
		return getSqlSession().selectOne("userMapper.getUser", vo);
	}
}

package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.util.SqlSessionFactoryBean;

public class BoardDAO {

	private SqlSession mybatis; // 데이터베이스 연결 객체
	
	//생성자
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		
		mybatis.insert("boardMapper.insertBoard", vo);
		mybatis.commit();
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("boardMapper.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("boardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		
		return mybatis.selectOne("boardMapper.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return mybatis.selectList("boardMapper.getBoardList", vo);
	}
	
}

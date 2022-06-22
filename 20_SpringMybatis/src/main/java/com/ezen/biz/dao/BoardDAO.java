package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

/*
 *    -------  BOARD 테이블과 CRUD 기능을 처리할 클래스.  -------
 */

@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport {

	/*
	 * 부모 클래스의 세션 생성 메소드를 호출하여 데이터베이스에 연결할 세션을 생성
	 */

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 처리...");
		return getSqlSession().selectList("boardMapper.getBoardList", vo);
	}

	// 게시글 상세 조회 : seq 번호에 의한 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");

		return getSqlSession().selectOne("boardMapper.getBoard", vo);
	}

	// 게시글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");

		getSqlSession().insert("boardMapper.insertBoard", vo);

	}

	// 게시글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");

		getSqlSession().update("boardMapper.updateBoard", vo);
	}

	// 게시글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");

		getSqlSession().delete("boardMapper.deleteBoard", vo);
	}

}

package com.ezen.biz.board;

import java.util.List;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		BoardDAO bDao = new BoardDAO();

		vo.setTitle("Mybatis 프레임워크");
		vo.setWriter("홍길동");
		vo.setContent("Mybatis를 이용한 스프링MVC 구현");

		bDao.insertBoard(vo);

		// 게시글 조회
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = bDao.getBoardList(vo);

		for (BoardVO board : boardList) {
			System.out.println(board);
		}
	}
}

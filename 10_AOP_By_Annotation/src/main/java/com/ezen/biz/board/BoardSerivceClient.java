package com.ezen.biz.board;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;

/*
 * 	클라이언트 작성 및 실행.
 */

public class BoardSerivceClient {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 구동.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. BoardSerivceImpl 객체 Lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 게시글 등록.
		// 		BoardVO 객체 생성.
		// 		boardService의 insertBoard() 호출.
		for (int i=0; i<10; i++) {
			BoardVO board = new BoardVO();
			board.setTitle("게시글 제목" + i);
			board.setWriter("작성자" + i);
			board.setContent("스프링 예제 게시글입니다.");
			
			boardService.insertBoard(board);
		}
		
		// 4. 게시글 전체 목록 출력.
		List<BoardVO> boardList = boardService.getBoardList();
		for (BoardVO vo : boardList) {
			System.out.println(vo);
		}
		container.close();
	}

}

package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class InsertBoardController {
	
	// 사용자 입력 정보추출, DB연동처리 제거, 여러개의 값이 있을때는 value를 기재
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("★ 게시글 등록 처리 ★");

		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";

	}
	
}

package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class GetBoardController {
	
	// 사용자 입력 정보추출, DB연동처리 제거, 여러개의 값이 있을때는 value를 기재
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDao, ModelAndView modelView) {

		BoardVO board = boardDao.getBoard(vo);
		
		// (3) 검색 결과를 세션에 저장하고 상세 화면을 리턴
		// 화면 응답 처리
		modelView.addObject("board", board); // Model 정보저장
		modelView.setViewName("getBoard.jsp");  // View 정보 저장
		
		return modelView;
	}

}

package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("게시글 상세 조회처리");
		
		// (1) 게시글 번호 입력값 추출
		String seq = request.getParameter("seq");
		
		// (2) DB 연동처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);

		
		// (3) 검색 결과를 세션에 저장하고 상세 화면을 리턴
		// 화면 응답 처리
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("board", board); // Model 정보저장 (내장객체에 조회한 내용 저장)
		modelView.setViewName("getBoard");  // View 정보 저장
		
		return modelView;
	}

}

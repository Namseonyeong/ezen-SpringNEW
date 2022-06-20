package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// 검색결과를 request객체에 저장하고 게시판 목록을 호출
		ModelAndView modelView = new ModelAndView();  // 객체 생성
		modelView.addObject("boardList", boardList );  //("속성명", 변수명)
		modelView.setViewName("getBoardList");
		
		return modelView;
		
		
	}

}

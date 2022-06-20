package com.ezen.view.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class GetBoardListController {

													// 커맨드객체를 '매개변수'에 지정해주면 객체 생성없이 사용가능
	// 사용자 입력 정보추출, DB연동처리 제거, 여러개의 값이 있을때는 value를 기재`
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDao, ModelAndView modelView) {
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// 두개의 값을 같이 넘겨주기위해 ModelAndView를 사용
		modelView.addObject("boardList", boardList );  //("속성명", 변수명)
		modelView.setViewName("getBoardList.jsp");
		
		return modelView;
		
		
	}

}

package com.ezen.view.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

//컨트롤러 통합 (게시글)
@Controller
public class BoardController {
	
	// 커맨드객체를 '매개변수'에 지정해주면 객체 생성없이 사용가능
	// 게시글 등록 : 사용자 입력 정보추출, DB연동처리 제거, 여러개의 값이 있을때는 value를 기재
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("★ 게시글 등록 처리 ★");

		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDao) {

		boardDao.updateBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDao) {
		// 게시글 일련번호로 확인 후 삭제
		boardDao.deleteBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 상세정보 조회 : Model 타입은 view가 아닌 타입만 return
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDao, Model model) {

		BoardVO board = boardDao.getBoard(vo);

		// 화면 응답 처리
		model.addAttribute("board", board); 

		return "getBoard.jsp";
	}
	
	// 게시글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDao, Model model) {
		List<BoardVO> boardList = boardDao.getBoardList();

		// 두개의 값을 같이 넘겨주기위해 ModelAndView를 사용
		model.addAttribute("boardList", boardList); // ("속성명", 변수명)
		
		return "getBoardList.jsp";

	}
}

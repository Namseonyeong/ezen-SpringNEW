package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dto.BoardListVO;
import com.ezen.biz.dto.BoardVO;

//컨트롤러 통합 (게시글)
@Controller
@SessionAttributes("board") // 세션 내장 객체에 board라는 이름으로 기스글 상세정보 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	// 커맨드객체를 '매개변수'에 지정해주면 객체 생성없이 사용가능
	// 게시글 등록 : 사용자 입력 정보추출, DB연동처리 제거, 여러개의 값이 있을때는 value를 기재
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("★ 게시글 등록 처리 ★");
		
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("fileName = " + fileName);
			uploadFile.transferTo(new File("D:\\student room_sy\\SpringWorkspace_NEW\\upload\\" + fileName));
		}
		
		boardService.insertBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 수정
	@RequestMapping("/updateBoard.do")  // modelattribute를 앞에 넣어주면 vo의 값이 board에 저장됨 
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("작성자 이름 : " + vo.getWriter());
		boardService.updateBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		// 게시글 일련번호로 확인 후 삭제
		boardService.deleteBoard(vo);

		return "getBoardList.do";
	}

	// 게시글 상세정보 조회 : Model 타입은 view가 아닌 타입만 return
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		BoardVO board = boardService.getBoard(vo);

		// 화면 응답 처리
		// model 객체에 board 데이터가 저장됨과 동시에 세션에도 저장됨 (SessionAttributes 설정시 : 이름이 같아야함)
		model.addAttribute("board", board); 

		return "getBoard.jsp";
	}
	
	// 검색 조건 목록
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
	
		Map<String, String> conditionMap = new LinkedHashMap<>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	// 게시글 목록 조회
	@RequestMapping("/getBoardList.do")   //requestParam (화면에 있는 데이터를 하나씩 가져올때 사용 : 제목, 내용 검색 /vo객체에 담을수 없는경우)
	public String getBoardList(
		//	@RequestParam(value = "searchCondition", defaultValue="TITLE", required=false) String condition,
		//	@RequestParam(value = "searchKeyword", defaultValue=" ", required=false) String keyword,
					BoardVO vo, Model model) {
		
		// searchCondition, searchKeyword 기본값 설정 
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		} 
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 키워드  : " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);

		// 검색결과를 request 객체에 저장하고 게시판 목록을 호출 (addAttribute에 넣어주면 request에 넣어준것과 같은 효과?)
		model.addAttribute("boardList", boardList); // ("속성명", 변수명)
		
		return "getBoardList.jsp";
	}
	
	
	/*
	 * JSON 데이터로 변환
	 */
	@RequestMapping("/dataTransForm.do")
	@ResponseBody // 를 써줘야만 데이터를 변환하여 리턴하는 어노테이션
	public List<BoardVO> dataTransform(BoardVO vo){
		// searchCondition, searchKeyword 기본값 설정 
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		} 
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
	/*
	 * XML 문서 형식으로 변환
	 */
	@RequestMapping("/dataTransForm_xml.do")  // 어떤 URL을 받을때 이 데이터를 처리할것인지
	@ResponseBody // jsp가 아니라 데이터 형식으로 rutnrn하는 어노테이션
	public BoardListVO dataTransformXML(BoardVO vo) {
		// searchCondition, searchKeyword 기본값 설정 
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		} 
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		BoardListVO boardListVO = new BoardListVO(); //List 객체 생성
		boardListVO.setBoardList(boardList);
		
		return boardListVO;
		
	}
	
	
	
	
	
	
	
}

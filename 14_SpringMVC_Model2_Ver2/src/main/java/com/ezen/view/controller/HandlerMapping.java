package com.ezen.view.controller;

import java.util.*;

public class HandlerMapping {
	//Controller 객체 등록하는 맵 변수 선언
	private Map<String, Controller> mappings;
	
	// 생성자 HandlerMapping 객체가 생성되면 어떤 동작을 할지 판단
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		
		// Controller 객체 등록
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
		
	/*
	 *  요청 URL에 대해, 알맞은 업무처리 Controller를 리턴한다.
	 *  login.do에서 요청이 들어오면 맵 변수를 찾아서 리턴을 해준다.
	 */
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
	
}

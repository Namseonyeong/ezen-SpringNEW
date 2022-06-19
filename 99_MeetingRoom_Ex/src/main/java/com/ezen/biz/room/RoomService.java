package com.ezen.biz.room;

import java.util.List;

import com.ezen.biz.dto.RoomVO;

public interface RoomService {

	int getMaxCapacity();

	// DAO에서 roomNama을 조회해서 값을 가져온다. 리턴 받은 값을 클라이언트에게 전달  
	String getRoomNameById(String roomId);

	//	roomById 값 가져오기 
	RoomVO getRoomById(String roomId);

	List<RoomVO> getAllRoom();
	
	void insertRoom(RoomVO vo);
	
	void updateRoom(RoomVO vo);
	
	void deleteRoom(RoomVO vo);
	
}
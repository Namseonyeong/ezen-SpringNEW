package com.ezen.biz.room;

import java.util.List;

import com.ezen.biz.dto.RoomVO;

public interface RoomService {

	int getMaxCapacity();

	// DAO���� roomNama�� ��ȸ�ؼ� ���� �����´�. ���� ���� ���� Ŭ���̾�Ʈ���� ����  
	String getRoomNameById(String roomId);

	//	roomById �� �������� 
	RoomVO getRoomById(String roomId);

	List<RoomVO> getAllRoom();
	
	void insertRoom(RoomVO vo);
	
	void updateRoom(RoomVO vo);
	
	void deleteRoom(RoomVO vo);
	
}
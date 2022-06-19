package com.ezen.biz.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dao.RoomDAO;
import com.ezen.biz.dto.RoomVO;

//클라이언트에서 호출할거기 때문에 Service 필수
@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	// Autowired 는 객체 자동 생성..? 
	@Autowired
	private RoomDAO roomDao;
	@Autowired
	private EquipmentDAO eDao;
	
	@Override
	public int getMaxCapacity() {
		
		return roomDao.findMaxCapacity();
	}
	
	// DAO에서 roomNama을 조회해서 값을 가져온다. 리턴 받은 값을 클라이언트에게 전달  
	@Override
	public String getRoomNameById(String roomId) {
		
		return roomDao.findRoomNameById(roomId);
	}
	
	// roomById 값 가져오기 
	@Override
	public RoomVO getRoomById(String roomId) {
		
		return roomDao.getRooomById(roomId);
	}
	
	@Override
	public List<RoomVO> getAllRoom() {
		
		return roomDao.getAllRoom();
	}
	
	// insert는 값을 전달해 주는것이 아니기 때문에 return이 없음. void 사용 
	@Override
	public void insertRoom(RoomVO vo) {
	
		roomDao.insertRoom(vo);
		
		// 시설목록 추가
		// RoomVO에 시설정보가 있으면 Equipment 테이블에 함께 insert / 1<vo.getEquipmentList().size() = 보다 작을때까지
		if (vo.getEquipmentList() != null) {
			for(int i=0; i<vo.getEquipmentList().size(); i++) {
				eDao.insertEquipment(vo.getEquipmentList().get(i));  //항목들이 하나씩 호출이 된다.
			}
		}
	}
	

	public void updateRoom(RoomVO vo) {
		
		roomDao.updateRoom(vo);
	}
	
	public void deleteRoom(RoomVO vo) {
		roomDao.deleteRoom(vo);
	}
	
	
}

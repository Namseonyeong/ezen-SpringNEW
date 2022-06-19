package com.ezen.biz.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dao.RoomDAO;
import com.ezen.biz.dto.RoomVO;

//Ŭ���̾�Ʈ���� ȣ���Ұű� ������ Service �ʼ�
@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	// Autowired �� ��ü �ڵ� ����..? 
	@Autowired
	private RoomDAO roomDao;
	@Autowired
	private EquipmentDAO eDao;
	
	@Override
	public int getMaxCapacity() {
		
		return roomDao.findMaxCapacity();
	}
	
	// DAO���� roomNama�� ��ȸ�ؼ� ���� �����´�. ���� ���� ���� Ŭ���̾�Ʈ���� ����  
	@Override
	public String getRoomNameById(String roomId) {
		
		return roomDao.findRoomNameById(roomId);
	}
	
	// roomById �� �������� 
	@Override
	public RoomVO getRoomById(String roomId) {
		
		return roomDao.getRooomById(roomId);
	}
	
	@Override
	public List<RoomVO> getAllRoom() {
		
		return roomDao.getAllRoom();
	}
	
	// insert�� ���� ������ �ִ°��� �ƴϱ� ������ return�� ����. void ��� 
	@Override
	public void insertRoom(RoomVO vo) {
	
		roomDao.insertRoom(vo);
		
		// �ü���� �߰�
		// RoomVO�� �ü������� ������ Equipment ���̺� �Բ� insert / 1<vo.getEquipmentList().size() = ���� ����������
		if (vo.getEquipmentList() != null) {
			for(int i=0; i<vo.getEquipmentList().size(); i++) {
				eDao.insertEquipment(vo.getEquipmentList().get(i));  //�׸���� �ϳ��� ȣ���� �ȴ�.
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

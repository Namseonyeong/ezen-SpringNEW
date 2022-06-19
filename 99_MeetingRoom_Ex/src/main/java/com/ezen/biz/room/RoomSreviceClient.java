// 0615 불러온 데이터를 출력할 클라이언트 
package com.ezen.biz.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;
import com.ezen.biz.equipment.EquipmentService;

public class RoomSreviceClient {

	private static RoomService roomService = null;
	private static EquipmentService eqService = null;

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// RoomService 타입의 룸 서비스 = 컨테이너의 getBean, 룸서비스
		roomService = (RoomService) container.getBean("roomService");
		eqService = (EquipmentService) container.getBean("equipmentService");

		// 회의실 정보 출력
		RoomVO room = roomService.getRoomById("A001");
		printRoom(room);
		
		
		// A001 회의실에 설치된 설비 수정 및 삭제
		EquipmentVO eVo1 = new EquipmentVO();
		eVo1.setEquipment_id("50-1");
		eVo1.setRoom_id("B004");
		eVo1.setEquipment_name("회의용 TABLE");
		eVo1.setEquipment_count(1);
		eVo1.setEquipment_remarks("회의용 테이블");
		eqService.updateEquipment(eVo1);
		
		//삭제
		EquipmentVO eVo2 = new EquipmentVO();
		eVo2.setEquipment_id("50-2");
		eqService.deleteEquipment(eVo2);
		
		//설비 수정, 삭제 확인
		room = roomService.getRoomById("B004");
		printRoom(room);
		
		

		// 새로운 회의실 추가
		// addRoomAndEquipment();
		
		// roomService.insertRoom(vo1);

		printAllRoom();

		// 회의실 정보 수정
		/*
		RoomVO vo1 = new RoomVO();
		vo1.setRoom_id("B003");
		vo1.setRoom_name("소회의실");
		vo1.setCapacity(5);
		roomService.updateRoom(vo1);

		System.out.println("<<< 수정 후 회의실 목록 >>>");
		printAllRoom();
		*/
		container.close();
	}

	public static void printRoom(RoomVO vo) {
		System.out.println(">> 회의실 정보 <<");
		System.out.println(vo);
		
		//부대시설 정보 출력
		System.out.println(">>>>> 부대시설 정보");
		if (vo.getEquipmentList() != null) {
			List<EquipmentVO> eList = vo.getEquipmentList();
			for (int i=0; i<eList.size(); i++) {
				System.out.println(eList.get(i));
			}
		}
	}
	
	
	
	public static void printAllRoom() {

		// 모든 회의실 정보 목록 출력
		List<RoomVO> roomList = roomService.getAllRoom();
		System.out.println("<<< 모든 회의실 정보 >>>");
		for (RoomVO vo : roomList) {
			System.out.println(vo);
		}
	}

	// 장비리스트 추가 
	public static void addRoomAndEquipment() {
		// 새로운 회의실 추가 (저장)
		RoomVO vo1 = new RoomVO();
		vo1.setRoom_id("B004");
		vo1.setRoom_name("방문객 회의실");
		vo1.setCapacity(5);
		
		// 시설 목록 추가 : Equipment_id가 같을 경우 트랜젝션 동작 여부 확인해봄
		List<EquipmentVO> eList = new ArrayList<EquipmentVO>();
		
		EquipmentVO eVO1 = new EquipmentVO();
		eVO1.setEquipment_id("50-1");
		eVO1.setEquipment_name("회의용 테이블");
		eVO1.setEquipment_count(1);
		eVO1.setEquipment_remarks("6인용 회의 테이블");
		eVO1.setRoom_id("B004");
		eList.add(eVO1);
		
		EquipmentVO eVO2 = new EquipmentVO();
		eVO2.setEquipment_id("50-2");
		eVO2.setEquipment_name("테이블 의자");
		eVO2.setEquipment_count(6);
		eVO2.setEquipment_remarks("회의 테이블 의자");
		eVO2.setRoom_id("B004");
		eList.add(eVO2);
		
		// 회의실 장비 목록에 새로운 장비 추가
		vo1.setEquipmentList(eList);
		
		roomService.insertRoom(vo1); // room, equipment 테이블에 새로운 행 추가

	}

}

package com.ezen.biz.equipment;

import com.ezen.biz.dto.EquipmentVO;

public interface EquipmentService {

	void insertEquipment(EquipmentVO vo);
	
	void updateEquipment(EquipmentVO vo);
	
	void deleteEquipment(EquipmentVO vo);

}
package com.ezen.biz.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dto.EquipmentVO;


@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDAO eDao;

	@Override
	public void insertEquipment(EquipmentVO vo) {
		
		eDao.insertEquipment(vo);
	}
	
	@Override
	public void updateEquipment(EquipmentVO vo) {
		
		eDao.updateEquipment(vo);
	}

	@Override
	public void deleteEquipment(EquipmentVO vo) {
		
		eDao.deleteEquipment(vo);
	}
}

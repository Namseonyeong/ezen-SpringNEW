package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.EquipmentVO;


@Repository("equipmentDao")
public class EquipmentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 부대시설 관련 SQL
	private static final String INSERT_EQUIPMENT =
		    "INSERT INTO equipment VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_EQUIPMENT =
			"UPDATE equipment SET room_id=?, equipment_name, equipment_count, equipment_remarks=? "
				+ " WHERE equipment_id=?";
	private static final String DELETE_EQUIPMENT = 
			"DELETE FROM equipment WHERE room_id=?";
	private static final String GET_EQUIPMENT_BY_ROOMID = 
			"SELECT * FROM equipment WHERE room_id=?";
	
	
	
	public void insertEquipment(EquipmentVO vo) {
		Object[] args = {vo.getEquipment_id(), vo.getRoom_id(), vo.getEquipment_name(),
						vo.getEquipment_count(), vo.getEquipment_remarks()};
		
		
		jdbcTemplate.update(INSERT_EQUIPMENT, args);
	}
	
	public void updateEquipment(EquipmentVO vo) {
		Object[] args = {vo.getRoom_id(), vo.getEquipment_name(), vo.getEquipment_count(),
				 vo.getEquipment_remarks(), vo.getEquipment_id()};
		
		jdbcTemplate.update(UPDATE_EQUIPMENT, args);
	}
	
	public void deleteEquipment(EquipmentVO vo) {
		Object[] arge = {vo.getEquipment_id()};
		
		jdbcTemplate.update(DELETE_EQUIPMENT, arge);
	}
	
	
	// 회의실 ID를 조건으로 회의실 장비 조회
	public List<EquipmentVO> getEquipmentByRoomid(String roomId) {
		Object[] args = {roomId};
		
		return jdbcTemplate.query(GET_EQUIPMENT_BY_ROOMID, args, new EquipmentRowMapper());
	}
	
	class EquipmentRowMapper implements RowMapper<EquipmentVO> {

		@Override
		public EquipmentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EquipmentVO vo = new EquipmentVO();
			
			vo.setEquipment_id(rs.getString("equipment_id"));
			vo.setRoom_id(rs.getString("room_id"));
			vo.setEquipment_name(rs.getString("equipment_name"));
			vo.setEquipment_count(rs.getInt("equipment_count"));
			vo.setEquipment_remarks(rs.getString("equipment_remarks"));
			
			return vo;
		}
		
	}
}
	
	


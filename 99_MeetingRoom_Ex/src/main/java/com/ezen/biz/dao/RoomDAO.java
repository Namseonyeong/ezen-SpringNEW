package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;

//�������丮�� ����Ϸ��� ���ø����̼ǿ��� ������ ��Ű�� com.ezen.biz �ؿ� �־�ߵȴ�
@Repository("roomDao")
public class RoomDAO {

//	Spring JDBC�� �̿��Ͽ� �����ϰ� ��. : JdbcTe �̶�� ��ü�� �̿��Ͽ� ����
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EquipmentDAO eDao;
	
//	sql�� 
	private static final String SELECT_MAX_CAPACITY =
			"SELECT MAX(capacity) FROM room";
	private static final String GET_ROOM_NAME =
			"SELECT room_name FROM room WHERE room_id=?";
	private static final String GET_ROOM_INFO =
			"SELECT * FROM room WHERE room_id=?";
	private static final String GET_ALL_ROOM =
			"SELECT * FROM room ORDER BY room_name"; // ORDER BY - �������
	private static final String INSERT_ROOM =
			"INSERT INTO room VALUES(?, ?, ?)";
	private static final String UPDATE_ROOM =
			"UPDATE room SET room_name=?, capacity=? WHERE room_id=?";
	private static final String DELETE_ROOM = 
			"DELETE FROM room WHERE room_id=?";
	
	
	/*
	 * ȸ�ǽ� �ִ� �����ο� ��ȸ
	 */
	public int findMaxCapacity() {
		
		// ��ȸ ��� ������ ���Ϲ޴� ��� = ���� �ڿ� , ���Ϲ��� Ÿ�� ����
		return jdbcTemplate.queryForObject(SELECT_MAX_CAPACITY, Integer.class);
	}
	
	/*
	 * ȸ�ǽ� ��ȣ�� �������� ȸ�ǽǸ� ��ȸ
	 */
	public String findRoomNameById(String roomId) {
		// ����� ? �� ������ ���� (rommid�� ������ �˻�) ������Ʈ �迭�� �޾ƿ� ���� ����
		Object[] args = {roomId};
		
		return jdbcTemplate.queryForObject(GET_ROOM_NAME, args, String.class);
	}
	
	/*
	 * ȸ�ǽ� ��ȣ�� �������� ȸ�ǽ� ���� ��ȸ
	 * �ϳ��� ȸ�ǽ� ������ �������� RoomRowMapper�� ���� �־���
	 */
	public RoomVO getRooomById(String roomId) {
		Object[] args = {roomId};
		
		RoomVO room = jdbcTemplate.queryForObject(GET_ROOM_INFO, args, new RoomRowMapper());
		
		//�δ�ü� ���� ��ȸ (���)
		List<EquipmentVO> equipList = eDao.getEquipmentByRoomid(roomId);
		
		// �ü� ����Ʈ roomList�� �־��ֱ�
		room.setEquipmentList(equipList);
		return room;
	}
	
	/*
	 * ��� ȸ�ǽ� ���� ��� ������
	 */
	public List<RoomVO> getAllRoom() {
		// �޼ҵ�� ��ü �����͸� �޾ƿ��� ������ query ���, ��� �ʵ带 �������� ������ new RoomRowMapper ���
		return jdbcTemplate.query(GET_ALL_ROOM, new RoomRowMapper());
	}
	
	/*
	 * ȸ�ǽ� ������ ���� (�ü��� �߰�)
	 */
	public void insertRoom(RoomVO room) {
		// ��ܿ� 3���� ���� �ҷ����� ������ �迭�� �����Ͽ� ������ ���� �������ش� 
		Object[] args = {room.getRoom_id(), room.getRoom_name(), room.getCapacity()};
		
		// INSETE, DELETE, UPDATE �Ҷ��� update�� ������ش�
		jdbcTemplate.update(INSERT_ROOM, args);
	}
	
	/*
	 * ȸ�ǽ��� ���� ���� �޼ҵ�
	 * ���ϰ� : ������ ���� ��
	 */
	public int updateRoom(RoomVO room) {
		Object[] args = { room.getRoom_name(),  room.getCapacity(), room.getRoom_id()};
		
		return jdbcTemplate.update(UPDATE_ROOM, args);
	}
	
	/*
	 * ȸ�ǽ� ���� ����
	 * ���ϰ� : ������ ���� ��
	 */
	public int deleteRoom(RoomVO room) {
		Object[] args = {room.getRoom_id()};
		
		return jdbcTemplate.update(DELETE_ROOM, args);
	}
	

	
	// �������̽��� �����ϴ� calss
	class RoomRowMapper implements RowMapper<RoomVO> {
		
		@Override
		public RoomVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoomVO room = new RoomVO();
			
			room.setRoom_id(rs.getString("room_id"));
			room.setRoom_name(rs.getString("room_name"));
			room.setCapacity(rs.getInt("capacity"));
			
			return room;
		}
		
	}
	
}

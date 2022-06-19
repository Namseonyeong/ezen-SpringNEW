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

//레퍼지토리를 사용하려면 어플리케이션에서 설정한 패키지 com.ezen.biz 밑에 있어야된다
@Repository("roomDao")
public class RoomDAO {

//	Spring JDBC를 이용하여 접근하게 됨. : JdbcTe 이라는 객체를 이용하여 접근
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EquipmentDAO eDao;
	
//	sql문 
	private static final String SELECT_MAX_CAPACITY =
			"SELECT MAX(capacity) FROM room";
	private static final String GET_ROOM_NAME =
			"SELECT room_name FROM room WHERE room_id=?";
	private static final String GET_ROOM_INFO =
			"SELECT * FROM room WHERE room_id=?";
	private static final String GET_ALL_ROOM =
			"SELECT * FROM room ORDER BY room_name"; // ORDER BY - 순서대로
	private static final String INSERT_ROOM =
			"INSERT INTO room VALUES(?, ?, ?)";
	private static final String UPDATE_ROOM =
			"UPDATE room SET room_name=?, capacity=? WHERE room_id=?";
	private static final String DELETE_ROOM = 
			"DELETE FROM room WHERE room_id=?";
	
	
	/*
	 * 회의실 최대 수용인원 조회
	 */
	public int findMaxCapacity() {
		
		// 조회 결과 정수를 리턴받는 경우 = 쿼리 뒤에 , 리턴받을 타입 기재
		return jdbcTemplate.queryForObject(SELECT_MAX_CAPACITY, Integer.class);
	}
	
	/*
	 * 회의실 번호를 조건으로 회의실명 조회
	 */
	public String findRoomNameById(String roomId) {
		// 상단의 ? 로 지정된 값은 (rommid로 조건을 검색) 오브젝트 배열에 받아온 값을 설정
		Object[] args = {roomId};
		
		return jdbcTemplate.queryForObject(GET_ROOM_NAME, args, String.class);
	}
	
	/*
	 * 회의실 번호를 조건으로 회의실 정보 조회
	 * 하나의 회의실 정보를 가져오면 RoomRowMapper에 값을 넣어줌
	 */
	public RoomVO getRooomById(String roomId) {
		Object[] args = {roomId};
		
		RoomVO room = jdbcTemplate.queryForObject(GET_ROOM_INFO, args, new RoomRowMapper());
		
		//부대시설 정보 조회 (장비)
		List<EquipmentVO> equipList = eDao.getEquipmentByRoomid(roomId);
		
		// 시설 리스트 roomList에 넣어주기
		room.setEquipmentList(equipList);
		return room;
	}
	
	/*
	 * 모든 회의실 정보 목록 얻어오기
	 */
	public List<RoomVO> getAllRoom() {
		// 메소드로 전체 데이터를 받아오기 때문에 query 사용, 모든 필드를 가져오기 때문에 new RoomRowMapper 사용
		return jdbcTemplate.query(GET_ALL_ROOM, new RoomRowMapper());
	}
	
	/*
	 * 회의실 정보를 저장 (시설을 추가)
	 */
	public void insertRoom(RoomVO room) {
		// 상단에 3개의 값을 불러오기 때문에 배열을 선언하여 가져올 값을 지정해준다 
		Object[] args = {room.getRoom_id(), room.getRoom_name(), room.getCapacity()};
		
		// INSETE, DELETE, UPDATE 할때는 update를 사용해준다
		jdbcTemplate.update(INSERT_ROOM, args);
	}
	
	/*
	 * 회의실을 정보 수정 메소드
	 * 리턴값 : 수정된 행의 수
	 */
	public int updateRoom(RoomVO room) {
		Object[] args = { room.getRoom_name(),  room.getCapacity(), room.getRoom_id()};
		
		return jdbcTemplate.update(UPDATE_ROOM, args);
	}
	
	/*
	 * 회의실 정보 삭제
	 * 리턴값 : 삭제된 행의 수
	 */
	public int deleteRoom(RoomVO room) {
		Object[] args = {room.getRoom_id()};
		
		return jdbcTemplate.update(DELETE_ROOM, args);
	}
	

	
	// 인터페이스를 구현하는 calss
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

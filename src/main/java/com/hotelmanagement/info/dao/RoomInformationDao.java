package com.hotelmanagement.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotelmanagement.info.model.RoomInformationModel;

public interface RoomInformationDao extends JpaRepository<RoomInformationModel, Integer> {
	
	@Query("SELECT room from room_information  room where room.is_vacant = true")       
    public List<RoomInformationModel> findVacantRooms();
	
	@Query("SELECT room from room_information  room where room.is_vacant = false")       
    public List<RoomInformationModel> findOccupiedRooms();

}

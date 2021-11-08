package com.hotelmanagement.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.info.dao.RoomInformationDao;
import com.hotelmanagement.info.model.RoomInformationModel;

@Service
public class RoomInformationService {
	
	@Autowired
	RoomInformationDao roomInformationDao;
	
	public List<RoomInformationModel> getAllRooms()
	{	
		return roomInformationDao.findAll();
	}
	
	public List<RoomInformationModel> getVacantRooms()
	{	
		return roomInformationDao.findVacantRooms();
	}
	
	public List<RoomInformationModel> getOccupiedRooms()
	{	
		return roomInformationDao.findOccupiedRooms();
	}

	
	
}

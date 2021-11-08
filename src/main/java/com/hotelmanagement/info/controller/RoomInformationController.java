package com.hotelmanagement.info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.info.model.HotelResponseEntity;
import com.hotelmanagement.info.model.RoomInformationModel;
import com.hotelmanagement.info.service.RoomInformationService;

@RestController
public class RoomInformationController {

	@Autowired
	RoomInformationService roomInformationService;

	@Autowired
	HotelResponseEntity hotelResponseEntity;

	@GetMapping("/getAllRooms")
	public ResponseEntity getAllRooms(){

		try {
			List<RoomInformationModel> roomInformationList = roomInformationService.getAllRooms();
			return new ResponseEntity<>(hotelResponseEntity.allRooms(roomInformationList),HttpStatus.OK);
		}

		catch(Exception e) {
			return  new ResponseEntity<Map>(hotelResponseEntity.errorResponseReponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	@GetMapping("/showVacantRooms")
	public ResponseEntity getVacantRooms(){

		try {
			List<RoomInformationModel> roomInformationList = roomInformationService.getVacantRooms();
			return new ResponseEntity<>(hotelResponseEntity.allRooms(roomInformationList),HttpStatus.OK);
		}

		catch(Exception e) {
			return  new ResponseEntity<Map>(hotelResponseEntity.errorResponseReponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}
	}

		@GetMapping("/showOccupiedRooms")
		public ResponseEntity getOccupiedRooms(){

			try {
				List<RoomInformationModel> roomInformationList = roomInformationService.getOccupiedRooms();
				return new ResponseEntity<>(hotelResponseEntity.allRooms(roomInformationList),HttpStatus.OK);
			}

			catch(Exception e) {
				return  new ResponseEntity<Map>(hotelResponseEntity.errorResponseReponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
			}

	}

}

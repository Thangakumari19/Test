package com.hotelmanagement.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.info.model.CheckInOutModel;
import com.hotelmanagement.info.model.HotelResponseEntity;
import com.hotelmanagement.info.service.CheckInOutService;

import lombok.NonNull;


@RestController
public class CheckInOutController {

	@Autowired
	CheckInOutService checkInOutService;

	@Autowired
	HotelResponseEntity hotelResponseEntity;

	/*Customer can check-in with name and entryTime
	 *Check-out time can be mentioned during check-in itself or can be null 
	 *If Check-Out time needs to be extended , use 'updateCheckOut' API
	 */

	@PostMapping("/insertCheckIn")
	public ResponseEntity insertCheckInDetails (@RequestBody @NonNull CheckInOutModel checkInOutModel) {
		try{
			checkInOutService.insertCheckInDetails(checkInOutModel);
			return new ResponseEntity(hotelResponseEntity.successReponse("Check-In done!!"),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity(hotelResponseEntity.errorResponseReponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/*
	 *If Check-Out time needs to be extended , use 'updateCheckOut' API
	 *Based on the id the check-out time can be updated
	 */

	@PutMapping("/updateCheckOut")
	public ResponseEntity<CheckInOutController> insertCheckOutDetails (@RequestBody @NonNull CheckInOutModel checkInOutModel) {
		try{
			checkInOutService.updateCheckOutDetails(checkInOutModel);
			return new ResponseEntity<CheckInOutController>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<CheckInOutController>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}

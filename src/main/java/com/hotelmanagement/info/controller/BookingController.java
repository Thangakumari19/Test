package com.hotelmanagement.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.info.model.BookingModel;
import com.hotelmanagement.info.model.HotelResponseEntity;
import com.hotelmanagement.info.service.BookingService;

import lombok.NonNull;

@RestController
public class BookingController {


	@Autowired
	BookingService bookingService;
	
	@Autowired
	HotelResponseEntity hotelResponseEntity;
	
	@PostMapping("/generateReciept")
	public ResponseEntity generateBookingReciept(@RequestBody @NonNull BookingModel bookingModel) {
		
		try {
			
			bookingService.insertBookingInfo(bookingModel);
			return new ResponseEntity(hotelResponseEntity.generateRecieptSuccessfully(bookingModel),HttpStatus.OK);
		}
		
		catch(Exception e) {
			return new ResponseEntity(hotelResponseEntity.errorResponseReponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}
	}

}

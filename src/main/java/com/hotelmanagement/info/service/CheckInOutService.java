package com.hotelmanagement.info.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.info.dao.CheckInOutDao;
import com.hotelmanagement.info.model.CheckInOutModel;

import lombok.NonNull;

@Service
public class CheckInOutService {
	
	@Autowired
	CheckInOutDao checkInOutDao;
	
	public int insertCheckInDetails(CheckInOutModel checkInOutModel) {
			checkInOutDao.save(checkInOutModel);	
			return checkInOutModel.getGovtId();
	}

	public void updateCheckOutDetails(CheckInOutModel checkInOutModel) throws Exception {
		Optional<CheckInOutModel> customerDetails = checkInOutDao.findById(checkInOutModel.getGovtId());
		if(customerDetails.isPresent()) {
		customerDetails.get().setTimeOut(checkInOutModel.getTimeOut());
		checkInOutDao.save(customerDetails.get());
		}
		else {
			throw new Exception("Customer info is not valid!!");
		}

	}
	
	
	

}

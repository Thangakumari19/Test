package com.hotelmanagement.info.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.info.dao.BookingDao;
import com.hotelmanagement.info.model.BookingModel;

@Service
public class BookingService {

	@Autowired
	BookingDao bookingDao;

	public BookingModel insertBookingInfo(BookingModel bookingModel) throws DataFormatException {
		String regex= "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(bookingModel.getAadharNumber());
		if(!m.matches()) {
			throw new DataFormatException("Aadhar Number is in-valid!!");
		}
		return bookingDao.save(bookingModel);
	}

}

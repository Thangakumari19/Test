package com.hotelmanagement.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.info.model.BookingModel;

public interface BookingDao extends JpaRepository<BookingModel, String>{

}

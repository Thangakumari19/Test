package com.hotelmanagement.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOKING_INFORMATION")

public class BookingModel {
	
	@Id
	@Column(length = 14)
	private String aadharNumber;
	
	@NonNull
	private String name;
	
	@NonNull
	private Integer age;
	
	@NonNull
	private String address;
	
	@NonNull
	private Integer roomNumber;
	
	@NonNull
	private Double amount;
	

}

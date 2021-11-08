package com.hotelmanagement.info.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ROOM_INFORMATION")

public class RoomInformationModel {
	
	@Id
	@NonNull
	private Integer roomNumber;
	
	@NonNull
	private Integer floorNumber;
	
	@NonNull
	private String roomType;
	
	@NonNull
	private Integer numberOfBeds;
	
	@NonNull
	private Boolean isVacant;
	
	

}

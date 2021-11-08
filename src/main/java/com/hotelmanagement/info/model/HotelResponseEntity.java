package com.hotelmanagement.info.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class HotelResponseEntity {


	public Map<String,Object> successReponse(Object data){
		Map<String,Object> entityMap = new LinkedHashMap<>();

		entityMap.put("Message", data);
		entityMap.put("code", 200);
		entityMap.put("Status", "Success");
		return entityMap;
	}

	public Map<String,Object> errorResponseReponse(HttpStatus status, String message) {
		Map<String,Object> entityMap = new LinkedHashMap<>();
		entityMap.put("Message", "Error checking in");
		entityMap.put("code", status);
		entityMap.put("description", message);
		return entityMap;
	}


	public Map<String,Object> generateRecieptSuccessfully(BookingModel data){
		Map<String,Object> entityMap = new LinkedHashMap<>();
		Map<String,Object> recieptMap = new LinkedHashMap<>();
		Map<String,Object> statusMap = new LinkedHashMap<>();


		recieptMap.put("Customer Name", data.getName());
		recieptMap.put("Customer Age", data.getAge());
		recieptMap.put("Residing at", data.getAddress());
		recieptMap.put("Amount Paid",data.getAmount());
		recieptMap.put("Room Number", data.getRoomNumber());

		statusMap.put("code", 200);
		statusMap.put("Status", "Success");

		entityMap.put("Reciept", recieptMap);
		entityMap.put("Response", statusMap);


		return entityMap;
	}

	public Map<String,Object> allRooms(List<RoomInformationModel> roomInformationList){
		Map<String,Object> entityMap = new LinkedHashMap<>();
		Map<String,Object> infoMap = new LinkedHashMap<>();
		List<Map<String,Object>> roomList = new ArrayList<>();
		Map<String,Object> statusMap = new LinkedHashMap<>();

		for (RoomInformationModel roomInformationModel : roomInformationList) {
			infoMap.put("Room Number", roomInformationModel.getRoomNumber());
			infoMap.put("Floor", roomInformationModel.getFloorNumber());
			infoMap.put("Room Type", roomInformationModel.getRoomType());
			infoMap.put("Number of Beds",roomInformationModel.getNumberOfBeds());

			if(roomInformationModel.getIsVacant()) {
				infoMap.put("Room Availability", "Vacant");
			}
			else {
				infoMap.put("Room Availability", "Occupied");
			}
			roomList.add(infoMap);
		}
		entityMap.put("Room Information", roomList);
		statusMap.put("code", 200);
		statusMap.put("Status", "Success");
		entityMap.put("Response", statusMap);

		return entityMap;
	}
}

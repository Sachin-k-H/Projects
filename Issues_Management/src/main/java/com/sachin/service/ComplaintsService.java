package com.sachin.service;

import java.util.List;

import com.sachin.dto.ComplaintsDto;

public interface ComplaintsService {
ComplaintsDto SaveComplaint(ComplaintsDto compalintsdto) ;

List<ComplaintsDto> getuserid(int userid);
List<ComplaintsDto> getallusers();
List<ComplaintsDto> getAllComplaintsBasedOnType(String type);
List<ComplaintsDto> getAllComplaintsBasedOnCity(String city);
List<ComplaintsDto> getAllComplaintsBasedOnTypeandCity(String type,String city);
ComplaintsDto getComplaintid(int d);
ComplaintsDto updateComplaint(ComplaintsDto compalintsdto) ;
}

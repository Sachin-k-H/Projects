package com.sachin.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sachin.dto.ComplaintHistory;
import com.sachin.dto.ComplaintsDto;
import com.sachin.repository.ComplaintHistoryRepository;
import com.sachin.repository.ComplaintsRepo;

@Service
public class ComplaintsServiceImpl implements ComplaintsService {

	@Autowired
	private ComplaintsRepo complaintsrepo;

	@Autowired
	private ComplaintHistoryRepository comhisrepo;

	@Override
	public ComplaintsDto SaveComplaint(ComplaintsDto complaintsdto) {

		// savecomplainthistory(complaintsdto);
		return complaintsrepo.save(complaintsdto);
	}

	public ComplaintHistory savecomplainthistory(ComplaintsDto complaintsdto) {
		ComplaintHistory complainthistory = new ComplaintHistory();
		complainthistory.setCid(complaintsdto.getId());
		complainthistory.setDescription(complaintsdto.getDescription());
		complainthistory.setStatus(complaintsdto.getStatus());
		complainthistory.setType(complaintsdto.getType());
		System.out.println(complainthistory);
		return comhisrepo.save(complainthistory);
	}

	@Override
	public List<ComplaintsDto> getuserid(int userid) {
		// TODO Auto-generated method stub
		return complaintsrepo.getbyuserid(userid);
	}

	@Override
	public List<ComplaintsDto> getallusers() {
		// TODO Auto-generated method stub
		return complaintsrepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<ComplaintsDto> getAllComplaintsBasedOnType(String type) {
		// TODO Auto-generated method stub
		return complaintsrepo.getComplaintstype(type);
	}

	@Override
	public List<ComplaintsDto> getAllComplaintsBasedOnCity(String city) {
		// TODO Auto-generated method stub
		return complaintsrepo.getComplaintcity(city);
	}

	@Override
	public List<ComplaintsDto> getAllComplaintsBasedOnTypeandCity(String type, String city) {
		// TODO Auto-generated method stub
		return complaintsrepo.getComplainttypecity(city, type);
	}

	@Override
	public ComplaintsDto getComplaintid(int d) {
		// TODO Auto-generated method stub
		return complaintsrepo.findById(d).get();
	}

	@Override
	public ComplaintsDto updateComplaint(ComplaintsDto compalintsdto) {

		return complaintsrepo.save(compalintsdto);
	}

	@Override
	public List<ComplaintsDto> getAllocatedComplaints(String departmentid) {

		return complaintsrepo.getAllocatedComplaints(departmentid).parallelStream()
				.sorted(Comparator.comparing(ComplaintsDto::getId).reversed()).collect(Collectors.toList());
	}
@Override
	public List<ComplaintsDto> getAllAssignedComplaints(int employeeid){
	return complaintsrepo.getAllAssignedComplaints(employeeid);	
	}
	
}

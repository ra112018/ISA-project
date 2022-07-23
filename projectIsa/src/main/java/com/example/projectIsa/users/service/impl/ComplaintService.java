package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.service.IRentingItemService;
import com.example.projectIsa.users.dto.ComplaintDTO;
import com.example.projectIsa.users.model.Complaint;
import com.example.projectIsa.users.repository.ComplaintRepository;
import com.example.projectIsa.users.service.IClientService;
import com.example.projectIsa.users.service.IComplaintService;

@Service
public class ComplaintService implements IComplaintService{

	private final ComplaintRepository complaintRepository;
	private final IClientService clientService;
	private final IRentingItemService rentingItemService;
	private final EmailService emailService;
	
	@Autowired
    public ComplaintService(ComplaintRepository complaintRepository, IClientService clientService,IRentingItemService rentingItemService,
    		EmailService emailService) {
        this.complaintRepository = complaintRepository;
        this.clientService = clientService;
        this.rentingItemService = rentingItemService;
        this.emailService = emailService;
    }
	
	@Override
	public Complaint createComplaint(ComplaintDTO dto) {
		
		Complaint complaint = new Complaint();
		complaint.setDescription(dto.getDescription());
		complaint.setClient(clientService.findById(dto.getClientId()));
		complaint.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        emailService.sendComplaintEmail(dto.getDescription(),complaint.getClient(),complaint.getRentingItem());
        return complaintRepository.save(complaint);
        
	}

}

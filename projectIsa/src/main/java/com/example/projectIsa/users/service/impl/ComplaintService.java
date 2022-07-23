package com.example.projectIsa.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.service.IRentingItemService;
import com.example.projectIsa.users.dto.ComplaintDTO;
import com.example.projectIsa.users.dto.ComplaintReplyDTO;
import com.example.projectIsa.users.model.Complaint;
import com.example.projectIsa.users.model.ComplaintReply;
import com.example.projectIsa.users.repository.ComplaintReplyRepository;
import com.example.projectIsa.users.repository.ComplaintRepository;
import com.example.projectIsa.users.service.IClientService;
import com.example.projectIsa.users.service.IComplaintService;

@Service
public class ComplaintService implements IComplaintService{

	private final ComplaintRepository complaintRepository;
	private final IClientService clientService;
	private final IRentingItemService rentingItemService;
	private final EmailService emailService;
	private final ComplaintReplyRepository complaintReplyRepository;
	
	@Autowired
    public ComplaintService(ComplaintRepository complaintRepository, IClientService clientService,IRentingItemService rentingItemService,
    		EmailService emailService, ComplaintReplyRepository complaintReplyRepository) {
        this.complaintRepository = complaintRepository;
        this.clientService = clientService;
        this.rentingItemService = rentingItemService;
        this.emailService = emailService;
        this.complaintReplyRepository = complaintReplyRepository;
    }
	
	@Override
	public Complaint createComplaint(ComplaintDTO dto) {
		
		Complaint complaint = new Complaint();
		complaint.setDescription(dto.getDescription());
		complaint.setAnswered(false);
		complaint.setClient(clientService.findById(dto.getClientId()));
		complaint.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        emailService.sendComplaintEmail(dto.getDescription(),complaint.getClient(),complaint.getRentingItem());
        return complaintRepository.save(complaint);
        
	}

	@Override
	public List<Complaint> getAll() {
		return complaintRepository.findAll();
	}

	@Override
	public ComplaintReply createComplaintReply(ComplaintReplyDTO dto) {
		
		ComplaintReply complaintReply = new ComplaintReply();
		complaintReply.setDescription(dto.getDescription());
		complaintReply.setClient(clientService.findById(dto.getClientId()));
		complaintReply.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
		
		Complaint complaint = complaintRepository.getById(dto.getComplaintId());
		complaint.setAnswered(true);
		complaintRepository.save(complaint);
		
        emailService.sendComplaintReplyEmail(dto.getDescription(),complaintReply.getClient(),complaintReply.getRentingItem());
        return complaintReplyRepository.save(complaintReply);
	}

	@Override
	public List<ComplaintReply> getAllReplies() {
		return complaintReplyRepository.findAll();
	}

}

package com.example.projectIsa.users.service;

import java.util.List;

import com.example.projectIsa.users.dto.ComplaintDTO;
import com.example.projectIsa.users.dto.ComplaintReplyDTO;
import com.example.projectIsa.users.model.Complaint;
import com.example.projectIsa.users.model.ComplaintReply;

public interface IComplaintService {

	Complaint createComplaint(ComplaintDTO dto);

	List<Complaint> getAll();

	ComplaintReply createComplaintReply(ComplaintReplyDTO dto);

	List<ComplaintReply> getAllReplies();

}

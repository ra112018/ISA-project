package com.example.projectIsa.users.service;

import com.example.projectIsa.users.dto.ComplaintDTO;
import com.example.projectIsa.users.model.Complaint;

public interface IComplaintService {

	Complaint createComplaint(ComplaintDTO dto);

}

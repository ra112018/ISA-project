package com.example.projectIsa.users.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.ComplaintDTO;
import com.example.projectIsa.users.service.IComplaintService;


@RestController
@RequestMapping(value = "/complaint")
public class ComplaintController {

	private final IComplaintService complaintService;
	
	public ComplaintController(IComplaintService complaintService) {
		this.complaintService = complaintService;
	}
	
	//@ClientAuthorization
    @PostMapping("/add")
    public ResponseEntity<?> addComplaint(@RequestBody ComplaintDTO dto) throws ParseException {
        try {
            complaintService.createComplaint(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

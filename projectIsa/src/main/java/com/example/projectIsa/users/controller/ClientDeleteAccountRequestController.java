package com.example.projectIsa.users.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.ClientDeleteAccountRequestDTO;
import com.example.projectIsa.users.dto.ClientDeleteAccountRequestReplyDTO;
import com.example.projectIsa.users.model.DeleteAccountRequest;
import com.example.projectIsa.users.service.IClientDeleteAccountRequestService;

@RestController
@RequestMapping(value = "/clientDeleteAccountRequests")
public class ClientDeleteAccountRequestController {

	private final IClientDeleteAccountRequestService clientDeleteAccountRequestService;
	
	public ClientDeleteAccountRequestController(IClientDeleteAccountRequestService clientDeleteAccountRequestService) {
		this.clientDeleteAccountRequestService = clientDeleteAccountRequestService;
	}
	
	//@ClientAuthorization
    @PostMapping("/add")
    public ResponseEntity<?> addDeleteAccountRequest(@RequestBody ClientDeleteAccountRequestDTO dto) throws ParseException {
        try {
        	clientDeleteAccountRequestService.createDeleteAccountRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //@SystemAdminAuthorization
    @GetMapping("/getAll")
    public List<DeleteAccountRequest> getAll() throws ParseException {
        return clientDeleteAccountRequestService.getAll();
    }

    //@SystemAdminAuthorization
    @PostMapping("/approve")
    public boolean approve(@RequestBody ClientDeleteAccountRequestReplyDTO dto) throws ParseException {
        try {
        	clientDeleteAccountRequestService.approveRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //@SystemAdminAuthorization
    @PostMapping("/deny")
    public boolean deny(@RequestBody ClientDeleteAccountRequestReplyDTO dto) throws ParseException {
        try {
        	clientDeleteAccountRequestService.denyRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

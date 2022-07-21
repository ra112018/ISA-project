package com.example.projectIsa.users.service;

import java.util.List;

import com.example.projectIsa.users.dto.ClientDeleteAccountRequestDTO;
import com.example.projectIsa.users.dto.ClientDeleteAccountRequestReplyDTO;
import com.example.projectIsa.users.model.DeleteAccountRequest;

public interface IClientDeleteAccountRequestService {

	DeleteAccountRequest createDeleteAccountRequest(ClientDeleteAccountRequestDTO dto);
	
	List<DeleteAccountRequest> getAll();
	
    DeleteAccountRequest approveRequest(ClientDeleteAccountRequestReplyDTO dto);
    
    DeleteAccountRequest denyRequest(ClientDeleteAccountRequestReplyDTO dto);

}

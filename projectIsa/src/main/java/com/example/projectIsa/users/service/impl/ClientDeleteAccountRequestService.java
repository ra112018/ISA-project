package com.example.projectIsa.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.ClientDeleteAccountRequestDTO;
import com.example.projectIsa.users.dto.ClientDeleteAccountRequestReplyDTO;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.model.DeleteAccountRequest;
import com.example.projectIsa.users.repository.ClientDeleteAccountRequestRepository;
import com.example.projectIsa.users.repository.ClientRepository;
import com.example.projectIsa.users.service.IClientDeleteAccountRequestService;
import com.example.projectIsa.users.service.IClientService;

@Service
public class ClientDeleteAccountRequestService implements IClientDeleteAccountRequestService{

	private final ClientDeleteAccountRequestRepository clientDeleteAccountRequestRepository;
	private final ClientRepository clientRepository;
    private final IClientService clientService;
    private final EmailService emailService;
    
    @Autowired
	public ClientDeleteAccountRequestService(ClientDeleteAccountRequestRepository clientDeleteAccountRequestRepository, IClientService clientService,
			EmailService emailService, ClientRepository clientRepository) {
		this.clientDeleteAccountRequestRepository = clientDeleteAccountRequestRepository;
		this.clientService = clientService;
		this.emailService = emailService;
		this.clientRepository = clientRepository;
	}
    
    
	@Override
	public DeleteAccountRequest createDeleteAccountRequest(ClientDeleteAccountRequestDTO dto) {
		DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
		deleteAccountRequest.setDescription(dto.getDescription());
		deleteAccountRequest.setApproved(false);
        deleteAccountRequest.setClient(clientService.findById(dto.getClientId()));
        emailService.sendClientAccountDeletionRequest(deleteAccountRequest.getDescription(), deleteAccountRequest.getClient());
        return clientDeleteAccountRequestRepository.save(deleteAccountRequest);
	}
	
	@Override
    public List<DeleteAccountRequest> getAll() {
        return clientDeleteAccountRequestRepository.findAll();
    }

    @Override
    public DeleteAccountRequest approveRequest(ClientDeleteAccountRequestReplyDTO dto) {
        DeleteAccountRequest deleteAccountRequest = clientDeleteAccountRequestRepository.getById(dto.getClientDeleteAccountRequestId());
        deleteAccountRequest.setApproved(true);
        Client client = clientRepository.getById(deleteAccountRequest.getClient().getId());
        client.setDeleted(true);
        clientRepository.save(client);
        emailService.sendClientAccountDeletionApproveReplyRequest(deleteAccountRequest.getClient());
        clientDeleteAccountRequestRepository.delete(deleteAccountRequest);
        return deleteAccountRequest;
    }

    @Override
    public DeleteAccountRequest denyRequest(ClientDeleteAccountRequestReplyDTO dto) {
        DeleteAccountRequest deleteAccountRequest = clientDeleteAccountRequestRepository.getById(dto.getClientDeleteAccountRequestId());
        deleteAccountRequest.setApproved(false);
        emailService.sendClientAccountDeletionDenyRequest(dto.getDescription(),deleteAccountRequest.getClient());
        clientDeleteAccountRequestRepository.delete(deleteAccountRequest);
        return deleteAccountRequest;
    }

}

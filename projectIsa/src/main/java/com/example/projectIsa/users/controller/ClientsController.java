package com.example.projectIsa.users.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.ChangePasswordDTO;
import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.mapper.ClientMapper;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.service.IClientService;
import com.example.projectIsa.users.service.impl.CustomUserDetailsService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
@RequestMapping(value = "/client")
public class ClientsController {
	
	private final IClientService clientService;
	
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	public ClientsController(IClientService clientService) {
		this.clientService = clientService;
	}
	
	
	@PostMapping(value = "/registration", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerClient(@RequestBody ClientDTO clientDto) throws ParseException {
		try {
			clientService.registerClient(clientDto);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/activateAccount")
    public Client activateAccount(@RequestBody String token){
        return clientService.activateAccount(token);
    }
	
	//@ClientAuthorization
    @GetMapping("/getById/{id}")
    public ClientDTO getById(@PathVariable int id){
        return ClientMapper.MapToDTO(clientService.findById(id));
    }
    
    //@ClientAuthorization
    @PutMapping("/update")
    public ClientDTO updateClient(@RequestBody ClientDTO dto) throws ParseException {
        ClientDTO clientDTO = new ClientDTO();
        try {
            clientDTO = clientService.updateClient(dto);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return clientDTO;
    }
    
    //@ClientAuthorization
    @PutMapping("/changePassword")
    public boolean changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
    	return userDetailsService.changePassword(changePasswordDTO);
    }

}

package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.example.projectIsa.config.EmailContext;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.model.PasswordToken;
import com.example.projectIsa.users.repository.PasswordTokenRepository;
import com.example.projectIsa.users.service.IEmailService;

@Service
public class EmailService implements IEmailService{
	
	private final PasswordTokenRepository passwordTokenRepository;
	private final EmailContext emailContext;
	
	@Autowired
    public EmailService(PasswordTokenRepository passwordTokenRepository, EmailContext emailContext) {
        this.passwordTokenRepository = passwordTokenRepository;
        this.emailContext = emailContext;
    }

	public void clientApproveRegistrationMail(Client client) {

        String title = "Account activation";
        PasswordToken passwordToken = passwordTokenRepository.findOneByEmail(client.getEmail());

        Context context = new Context();
        context.setVariable("name", String.format("%s %s", client.getName(), client.getSurname()));
        context.setVariable("link", String.format("http://localhost:8081/login/%s", passwordToken.getToken()));
        emailContext.send("firma4validation@gmail.com", title, "clientAccountActivation", context);
		
	}

	public void sendAllowedRegistrationEmail(String email, String name, String surname) {
		String title = "Registration approved!";

        Context context = new Context();
        context.setVariable("name", String.format("%s %s", name, surname));
        emailContext.send("firma4validation@gmail.com", title, "registrationApproved", context);
		
	}

	public void sendDeniedRegistrationEmail(String email, String name, String surname, String explanation) {
		String title = "Registration denied!";

        Context context = new Context();
        context.setVariable("name", String.format("%s %s %s", name, surname, explanation));
        emailContext.send("firma4validation@gmail.com", title, "registrationDenied", context);
		
	}
}

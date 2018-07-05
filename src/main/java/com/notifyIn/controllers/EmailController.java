package com.notifyIn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notifyIn.entities.EmailTemplate;
import com.notifyIn.repositories.EmailRepository;

@RestController
@RequestMapping(value = "email")
public class EmailController {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private void addClientDetails(@RequestBody EmailTemplate emailTemplate) {
		/*
		 * User user=
		 * userRepository.findOne(clientDetail.getClientUser().getId());
		 * clientDetail.setClientUser(user);
		 */ 
		//ModuleDetail moduleDetail=clientDetail.getModuleDetails().get(0);
		emailRepository.save(emailTemplate);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	private List<EmailTemplate> getAllSmsTemplates() {
		return emailRepository.findAll();
	}

}

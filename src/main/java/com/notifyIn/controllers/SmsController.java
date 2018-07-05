package com.notifyIn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notifyIn.entities.ModuleDetail;
import com.notifyIn.entities.SmsTemplate;
import com.notifyIn.repositories.SmsRepository;

@RestController
@RequestMapping(value = "sms")
public class SmsController {
	
	@Autowired
	private SmsRepository smsRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private void addClientDetails(@RequestBody SmsTemplate smsTemplate) {
		/*
		 * User user=
		 * userRepository.findOne(clientDetail.getClientUser().getId());
		 * clientDetail.setClientUser(user);
		 */ 
		//ModuleDetail moduleDetail=clientDetail.getModuleDetails().get(0);
		smsRepository.save(smsTemplate);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	private List<SmsTemplate> getAllSmsTemplates() {
		return smsRepository.findAll();
	}
	
	

}

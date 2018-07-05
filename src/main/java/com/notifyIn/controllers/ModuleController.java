package com.notifyIn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notifyIn.entities.ClientDetail;
import com.notifyIn.entities.ModuleDetail;
import com.notifyIn.entities.User;
import com.notifyIn.repositories.ClientDetailsRepository;
import com.notifyIn.repositories.ModuleRepository;
import com.notifyIn.repositories.UserRepository;

@RestController
@RequestMapping(value = "moduleDetails")
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	private List<ModuleDetail> getAllClientDetails() {
		return moduleRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private void addClientDetails(@RequestBody ModuleDetail moduleDetail) {
		/*
		 * User user=
		 * userRepository.findOne(clientDetail.getClientUser().getId());
		 * clientDetail.setClientUser(user);
		 */ 
		//ModuleDetail moduleDetail=clientDetail.getModuleDetails().get(0);
		moduleRepository.save(moduleDetail);
	}

}

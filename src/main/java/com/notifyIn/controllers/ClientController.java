package com.notifyIn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notifyIn.entities.ClientDetail;
import com.notifyIn.entities.User;
import com.notifyIn.repositories.ClientDetailsRepository;
import com.notifyIn.repositories.UserRepository;

@RestController
@RequestMapping(value="clientDetails")
public class ClientController {
	
	@Autowired
	private ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	private List<ClientDetail> getAllClientDetails() {
		return clientDetailsRepository.findAll();
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	private void addClientDetails(@RequestBody ClientDetail clientDetail) {
		//change user details after login setup
		User user= userRepository.findOne(clientDetail.getClientUser().getId());
		clientDetail.setClientUser(user);
		clientDetailsRepository.save(clientDetail);
	}
	

}

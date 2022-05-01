package com.javahelps.restservice.repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.model.Controller;

import com.javahelps.restservice.objects.LoginDetails;
import com.javahelps.restservice.objects.LoginReturn;
import com.javahelps.restservice.objects.SetUpProfileDetails;
import com.javahelps.restservice.objects.enterTeacherDetails;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserRepository {
	Controller systemController;
	
	public UserRepository() {
		super();
		this.systemController = Controller.getInstance();
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginReturn login(@RequestBody LoginDetails loginDetails) {
		LoginReturn ret =new LoginReturn();
		ret.setType(systemController.login(loginDetails.getUsername(),loginDetails.getPassword()));
		ret.setUsername(loginDetails.getUsername());
		return ret;

	}
	
	@RequestMapping(value = "/setUpProfile", method = RequestMethod.POST)
	public String setUpProfile(@RequestBody SetUpProfileDetails obj) {
		return systemController.setUpProfile(obj.getName(), obj.getCnic(), obj.getUsername(), obj.getPassword());	
	}
	
	@RequestMapping(value = "/enterTeacherDetails", method = RequestMethod.POST)
	public String enterHostelDetails(@RequestBody enterTeacherDetails obj) {
		return systemController.enterTeacherDetails(obj.getTeacherName(), obj.getUniversity(),obj.getDepartment(), obj.getLogin(), obj.getPassword());	
	}
		
}
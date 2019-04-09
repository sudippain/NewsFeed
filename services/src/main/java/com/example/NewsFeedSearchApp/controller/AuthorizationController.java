package com.example.NewsFeedSearchApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NewsFeedSearchApp.service.Userservice;
import com.example.NewsFeedSearchApp.models.*;
@RestController
@RequestMapping("common")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorizationController extends ErrorHandler {

	@Autowired
	Userservice userservice;
	
//	Get all  Users Only Admin Can Access This Method

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	
	@GetMapping("admin/getAllUsers")
	public List<User> getAllusers(){
		return userservice.getAllUsers();
	}
	
//	Get all Active Users Only Admin Can Access This Method
	
	@GetMapping("getAllAciveUser")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List <User> getAllActiveUser()
	{
		List<User> listAllActiveUser=userservice.getAllActiveUser();
		return listAllActiveUser;
		
	}
	
//	Get All Decative Users Only Admin Can Access This Method
	
	@GetMapping("getAllDeAciveUser")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllDeActiveUse(){
		List<User> listAllDeActiveUser=userservice.getAllDeActiveuser();
		return listAllDeActiveUser;
	}
//	This method is used for search user
	@GetMapping("/getSearchUsers/{userName}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getLikeUserName(@PathVariable("userName")String uname) {
		
		return userservice.searchUser(uname);
	}
//	 This Method Is used To Deactive An Account Only Admin Can Access This Method
	
	@PutMapping("active/{userEmail}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String activeUser(@PathVariable("userEmail") String userEmail){
		
		return userservice.blackListUser(userEmail);
		
		
	}
	
	
	
	
}

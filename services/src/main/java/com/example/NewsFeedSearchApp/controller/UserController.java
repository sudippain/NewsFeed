package com.example.NewsFeedSearchApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NewsFeedSearchApp.models.User;
import com.example.NewsFeedSearchApp.models.UserSearchHistory;
import com.example.NewsFeedSearchApp.service.Userservice;
import com.example.NewsFeedSearchApp.service.security.JwtGenerator;



@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends ErrorHandler {

	@Autowired
	private Userservice userservice;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtGenerator jwtGenerator;

	@Autowired
	PasswordEncoder encoder;

	
	@PostMapping("registerUser")
	public String registerUser(@Valid @RequestBody User user){
		System.out.println("Inside Controller");
		        
				return userservice.userRegistration(user);
				
		
		
	}
	@PostMapping("/login")
	public String login(@RequestBody User appUser) {
		System.out.println("Sudip");
		logger.info("inside login");
		
		if(!userservice.backListUserLogin(appUser)){
			return "User Already BlackListed";
		}
		else{
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(appUser.getUserEmail(), appUser.getUserPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtGenerator.generateToken(authentication);
		return jwt;
		}
	}
	
	@PostMapping("/userSearchNews")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void searchUser(@RequestBody UserSearchHistory userhistory){
		
		System.out.println("Inside Calling2");
		
		System.out.println(userservice.userSearch(userhistory));
		System.out.println(userhistory.getUserNewsSearch());
		
		
	}
	@GetMapping("/getUserDetails/{email}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public User userDetails(@PathVariable("email") String userEmail){
		
		System.out.println(userEmail);
		
		System.out.println(userservice.userDetails(userEmail));
    	return userservice.userDetails(userEmail);
			
		
	}
	
	@GetMapping("/getUserHistory/{email}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<UserSearchHistory> userNewsHistory(@PathVariable("email") String userEmail) {
		System.out.println("Inside History");
		return  userservice.userSearchHistory(userEmail);
	}

	
	@GetMapping("admin/getAllUsers")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllusers(){
		return userservice.getAllUsers();
	}
	
	@DeleteMapping("/deleteNewsHistory/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void deleteHistory(@PathVariable("id") int historyId){
		userservice.deleteHistory(historyId);
		
	}
	@GetMapping("/changeStatus/{userEmail}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void changeStatus(@PathVariable("userEmail")String email) {
		
		 userservice.blackListUser(email);
	}
	@GetMapping("/getSearchUsers/{userName}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getLikeUserName(@PathVariable("userName")String uname) {
		
		return userservice.searchUser(uname);
	}
	
	
}

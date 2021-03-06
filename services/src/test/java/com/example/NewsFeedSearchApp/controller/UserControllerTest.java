package com.example.NewsFeedSearchApp.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.NewsFeedSearchApp.models.User;
import com.example.NewsFeedSearchApp.models.UserSearchHistory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class) 
public class UserControllerTest {

	@Autowired
	private WebApplicationContext webapplicationcontext;
	private MockMvc mockmvc;
	
	@Before
	public void setup(){
		this.mockmvc=MockMvcBuilders.webAppContextSetup(this.webapplicationcontext).build();
	}
	
	//For Successfull registration
	@Test
	public void forSuccessfullRegistration()throws Exception {
		User u=new User();
		u.setUserId(1);
		u.setUserName("Sudip");
		u.setUserEmail("sobhon@gmail.com");
		u.setUserContactNumber("7896523611");
		u.setUserPassword("Sobhon1234@");
		u.setRole("ROLE_USER");
		u.setUserStatus(true);
		
		ObjectMapper omap=new ObjectMapper();
		mockmvc.perform(
				post("/user/registerUser").content(omap.writeValueAsString(u))
				.contentType("application/json;charset=UTF-8"))
		        .andExpect(content().string(containsString("User Registration Successfull"))
				);
	}
	
//	When Email Already Exists
		@Test
		public void registrationWhenEmailAlreadyExists()throws Exception {
			User u=new User();
			u.setUserId(1);
			u.setUserName("Sudip");
			u.setUserEmail("sobhon@gmail.com");
			u.setUserContactNumber("7896523611");
			u.setUserPassword("Sobhon1234@");
			u.setRole("ROLE_USER");
			u.setUserStatus(true);
			
			ObjectMapper omap=new ObjectMapper();
			mockmvc.perform(
					post("/user/registerUser").content(omap.writeValueAsString(u))
					.contentType("application/json;charset=UTF-8"))
			        .andExpect(content().string(containsString("Email Already Exists"))
					);
		}
		
	//	If Name is null
		@Test
		public void nameIsEmpty()throws Exception {
			User u=new User();
			u.setUserId(1);
			u.setUserName("");
			u.setUserEmail("sobhongmail.com"); //Here we missed @ 
			u.setUserContactNumber("789653611");
			u.setUserPassword("Sobhon1234@");
			u.setRole("ROLE_USER");
			u.setUserStatus(true);
			
			ObjectMapper omap=new ObjectMapper();
			mockmvc.perform(
					post("/user/registerUser").content(omap.writeValueAsString(u))
					.contentType("application/json;charset=UTF-8"))
			        .andExpect(content().string(containsString("Name canot be null"))
					);
		}
		
		
		//If userDetails does not match Name's pattern
				@Test
				public void notMatchNamePattern()throws Exception {
					User u=new User();
					u.setUserId(1);
					u.setUserName("Sudip@#");
					u.setUserEmail("sobhongmail.com");// Here we missed @ 
					u.setUserContactNumber("789653611");
					u.setUserPassword("Sobhon1234@");
					u.setRole("ROLE_USER");
					u.setUserStatus(true);
					
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/registerUser").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(content().string(containsString("Name can only contain alphabets"))
							);
				}
				
			//	If Email is null
				@Test
				public void emailIsEmpty()throws Exception {
					User u=new User();
					u.setUserId(1);
					u.setUserName("Sudip");
					u.setUserEmail(""); //Here we missed @ 
					u.setUserContactNumber("789653611");
					u.setUserPassword("Sobhon1234@");
					u.setRole("ROLE_USER");
					u.setUserStatus(true);
					
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/registerUser").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(content().string(containsString("Email Cant be null"))
							);
				}
	//	If userDetails does not match email's pattern
		@Test
		public void notMatchEmailPattern()throws Exception {
			User u=new User();
			u.setUserId(1);
			u.setUserName("Sudip");
			u.setUserEmail("sobhongmail.com");// Here we missed @ 
			u.setUserContactNumber("789653611");
			u.setUserPassword("Sobhon1234@");
			u.setRole("ROLE_USER");
			u.setUserStatus(true);
			
			ObjectMapper omap=new ObjectMapper();
			mockmvc.perform(
					post("/user/registerUser").content(omap.writeValueAsString(u))
					.contentType("application/json;charset=UTF-8"))
			        .andExpect(content().string(containsString("Email must Follow Email Pattern"))
					);
		}
		
		//If contact is null
		@Test
		public void contactIsEmpty()throws Exception {
			User u=new User();
			u.setUserId(1);
			u.setUserName("Sudip");
			u.setUserEmail("Sudip@gmail.com"); //Here we missed @ 
			u.setUserContactNumber("");
			u.setUserPassword("Sobhon1234@");
			u.setRole("ROLE_USER");
			u.setUserStatus(true);
			
			ObjectMapper omap=new ObjectMapper();
			mockmvc.perform(
					post("/user/registerUser").content(omap.writeValueAsString(u))
					.contentType("application/json;charset=UTF-8"))
			        .andExpect(content().string(containsString("Number canot be null"))
					);
		}
		
	//	If userDetails does not match phone number pattern
				@Test
				public void notMatchPhoneNumberPattern()throws Exception {
					User u=new User();
					u.setUserId(1);
					u.setUserName("Sudip");
					u.setUserEmail("sobhon@gmail.com"); //Here we missed @ 
					u.setUserContactNumber("78965311");
					u.setUserPassword("Sobhon1234@");
					u.setRole("ROLE_USER");
					u.setUserStatus(true);
					
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/registerUser").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(content().string(containsString("Number must be ten character"))
							);
				}
			//	If Password is null
				@Test
				public void passwordIsEmpty()throws Exception {
					User u=new User();
					u.setUserId(1);
					u.setUserName("Sudip");
					u.setUserEmail("Sudip@gmail.com"); //Here we missed @ 
					u.setUserContactNumber("7452869325");
					u.setUserPassword("");
					u.setRole("ROLE_USER");
					u.setUserStatus(true);
					
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/registerUser").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(content().string(containsString("Password Cant be null"))
							);
				}
			//	If userDetails does not match password  pattern
				@Test
				public void notMatchPasswordPattern()throws Exception {
					User u=new User();
					u.setUserId(1);
					u.setUserName("Sudip");
					u.setUserEmail("sobhon@gmail.com"); //Here we missed @ 
					u.setUserContactNumber("78965311");
					u.setUserPassword("Sobhonsddf34");
					u.setRole("ROLE_USER");
					u.setUserStatus(true);
					
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/registerUser").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(content().string(containsString("Password must contain at least eight characters, one capital letter, one small letter and at least one number"))
							);
				}
				
				
			//	If user wants to login correct username and password
				@Test
				public void loginTest()throws Exception{
					User u=new User();
					u.setUserEmail("anik@gmail.com");
					u.setUserPassword("Anik1234@");
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/login").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
							.andExpect(status().isOk()
							);
				}

				//If user wants to login with wrong username and password
				@Test
				public void loginTestWithBadUserDetails()throws Exception{
					User u=new User();
					u.setUserEmail("anik@gmail.com");
					u.setUserPassword("Ank1234@");
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/login").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
							.andExpect(status().isBadRequest())
							.andExpect(content().string(containsString("System Error It Could Handle By Admin"))
					        
							);
				}
				
			//	If user wants to save history of searchin item
				@Test
				@WithMockUser(roles="USER")
				public void saveHistoryOfNewsContent()throws Exception{
					UserSearchHistory u=new UserSearchHistory();
					u.setUserEmail("anik@gmail.com");
					u.setUserNewsSearch("Avangers");
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/userSearchNews").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
							.andExpect(status().isOk()
					
					        
							);
				}

				//	If Admin wants to save history of searchin item
				@Test
				@WithMockUser(roles="ADMIN")
				public void saveHistoryOfNewsContentFail()throws Exception{
					UserSearchHistory u=new UserSearchHistory();
					u.setUserEmail("anik@gmail.com");
					u.setUserNewsSearch("Avangers");
					ObjectMapper omap=new ObjectMapper();
					mockmvc.perform(
							post("/user/userSearchNews").content(omap.writeValueAsString(u))
							.contentType("application/json;charset=UTF-8"))
							.andExpect(status().isBadRequest()
					
					        
							);
				}
				//User Details Fetch By user
				@Test
				@WithMockUser(roles="USER")
				public void userDetailsTest() throws Exception{
					
					mockmvc.perform(
							get("/user/getUserDetails/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				//User Details Fetch By Admin 
				@Test
				@WithMockUser(roles="ADMIN")
				public void userDetailsTestFail() throws Exception{
					
					mockmvc.perform(
							get("/user/getUserDetails/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				//User Details Fetch By USer 
				@Test
				@WithMockUser(roles="USER")
				public void userHistoryTest() throws Exception{
					
					mockmvc.perform(
							get("/user/getUserDetails/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				//User Details Fetch By Admin 
				@Test
				@WithMockUser(roles="ADMIN")
				public void userHistoryTestFail() throws Exception{
					
					mockmvc.perform(
							get("/user/getUserDetails/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				
				//when Admin search for all user  
				@Test
				@WithMockUser(roles="ADMIN")
				public void listOfUserTest() throws Exception{
					
					mockmvc.perform(
							get("/user/admin/getAllUsers")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				//when User search for all user  
				@Test
				@WithMockUser(roles="USER")
				public void listOfUserTestFail() throws Exception{
					
					mockmvc.perform(
							get("/user/admin/getAllUsers")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				
				@Test
				@WithMockUser(roles="USER")
                  public void deleteHistoryByIdTest() throws Exception{
					
					mockmvc.perform(
							delete("/user/deleteNewsHistory/30")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				@Test
				@WithMockUser(roles="ADMIN")
                  public void deleteHistoryByIdTestFail() throws Exception{
					
					mockmvc.perform(
							delete("/user/deleteNewsHistory/30")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				@Test
				@WithMockUser(roles="ADMIN")
                  public void changeStatusOfUser() throws Exception{
					
					mockmvc.perform(
							get("/user/changeStatus/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				@Test
				@WithMockUser(roles="USER")
                  public void changeStatusOfUserFail() throws Exception{
					
					mockmvc.perform(
							get("/user/changeStatus/anik@gmail.com")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				@Test
				@WithMockUser(roles="ADMIN")
                  public void getUserByUserNameTest() throws Exception{
					
					mockmvc.perform(
							get("/user/getSearchUsers/sudip")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				@Test
				@WithMockUser(roles="USER")
                  public void getUserByUserNameTestFail() throws Exception{
					
					mockmvc.perform(
							get("/user/getSearchUsers/sudip")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}
				@Test
				@WithMockUser(roles="ADMIN")
                  public void deActiveUserListTest() throws Exception{
					
					mockmvc.perform(
							get("/common/getAllDeAciveUser")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isOk());
				}
				@Test
				@WithMockUser(roles="USER")
                  public void deActiveUserListTestFail() throws Exception{
					
					mockmvc.perform(
							get("/common/getAllDeAciveUser")
							.contentType("application/json;charset=UTF-8"))
					        .andExpect(status().isBadRequest());
				}


}

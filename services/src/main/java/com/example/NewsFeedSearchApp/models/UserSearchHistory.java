package com.example.NewsFeedSearchApp.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class UserSearchHistory {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userSearchId;
	
	@NotBlank(message="Must be Something")
	private String userNewsSearch;
	
	@CreationTimestamp
	private LocalDateTime serachTime;

	
	private String userEmail;


	

	

	public int getUserSearchId() {
		return userSearchId;
	}


	public void setUserSearchId(int userSearchId) {
		this.userSearchId = userSearchId;
	}




	public String getUserNewsSearch() {
		return userNewsSearch;
	}


	public void setUserNewsSearch(String userNewsSearch) {
		this.userNewsSearch = userNewsSearch;
	}


	public LocalDateTime getSerachTime() {
		return serachTime;
	}


	public void setSerachTime(LocalDateTime serachTime) {
		this.serachTime = serachTime;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	@Override
	public String toString() {
		return "UserSearchHistory [userSearchId=" + userSearchId + ", userNewsSearch=" + userNewsSearch
				+ ", serachTime=" + serachTime + ", userEmail=" + userEmail + "]";
	}
	
	
	
	

}

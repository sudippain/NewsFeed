package com.example.NewsFeedSearchApp.repositary;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.NewsFeedSearchApp.models.UserSearchHistory;





public interface UserHistoryrepository extends CrudRepository<UserSearchHistory,Integer> {

	
	@Query("select h from UserSearchHistory h where h.userEmail = :email order by h.serachTime desc")
				public List<UserSearchHistory> searchByUserEmail(@Param("email") String useremail);

    
	

}
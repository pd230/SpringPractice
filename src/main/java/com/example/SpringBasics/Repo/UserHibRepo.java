// Spring boot : favorite of developers - production-ready environment which enables the developers to directly focus on the logic
//instead of struggling with the configuration and setup.

//JpaRepository is a JPA (Java Persistence API) specific extension of Repository. It contains the full 
//API of CrudRepository and PagingAndSortingRepository . So it contains API for basic CRUD operations
//and also API for pagination and sorting.

//T: Domain type that repository manages (Generally the Entity/Model class name)
//ID:Type of the id of the entity that repository manages (Generally the wrapper class of your 
//   @Id that is created inside the Entity/Model class)


package com.example.SpringBasics.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBasics.model.UserHib;

import jakarta.transaction.Transactional;

public interface UserHibRepo extends JpaRepository<UserHib, Integer>{

	List<UserHib> findByUnameOrderByUid(String uname); //Query DSL
    
	@Modifying
	@Transactional
	@Query("update UserHib u set u.uname = :uname where u.uid = :uid")//JPQL
	int changeUname(@Param("uid") int uid, @Param("uname") String uname);
}
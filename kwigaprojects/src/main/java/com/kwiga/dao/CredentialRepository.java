package com.kwiga.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Credential;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Integer> {
	
	@Query("select c from Credential c where c.userName=?1")
	//@Query("select c from Credential c where c.userName=username")
	Credential findUserByName(String userName);
}

package com.kwiga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Credential;
import com.kwiga.Models.UserModel;
import com.kwiga.dao.CredentialRepository;

@Service
public class Credentialservice implements UserDetailsService {
	
	@Autowired
	private CredentialRepository credentialrepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
	public Optional<Credential> getCredential(Integer id) {
		return credentialrepository.findById(id);
	}
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fist way of using UserDetailservice
		///return new User("Aimee","123",new ArrayList<>());
		
		//second way
		return new User(username,"masengesho",new ArrayList<>());
	}
	*/

	
	public Credential findUserByName(String userName) {
		return credentialrepository.findUserByName(userName);
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Credential credential=credentialrepository.findUserByName(userName);
		if(credential==null) {
			throw new UsernameNotFoundException("this username was Not Found");
		}
		return new UserModel(credential);
	}


	public Iterable<Credential> getscredentials() {
		return credentialrepository.findAll();
	}
}

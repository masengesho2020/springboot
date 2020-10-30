package com.kwiga.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kwiga.Models.Address;
import com.kwiga.Models.Credential;
import com.kwiga.Models.User;
import com.kwiga.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ProfileService profileservice;
	//BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
//	public List<User> getAllusers() {
//		return (List<User>) userdao.findAll();
//	}
	
	public Optional<User> getUser(Integer id) {  
		return userdao.findById(id);
	}
		/*
	public User Adduser(User user) {
		user.getCredential().setUser(user);
		user.getCredential().setPassword(passwordEncoder.encode(user.getCredential().getPassword()));
		//user.getCredential().setPassword(bCryptPasswordEncoder.encode(user.getCredential().getPassword()));
		return userdao.save(user);
	}
	*/
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	public User findUserById(Integer id) {
		return userdao.findById(id).orElse(null);
	}

	public void deleteUserById(Integer id) {
		userdao.deleteById(id);
	}


	public List<User> findAll() {
		return (List<User>) userdao.findAll();
	}

	public User updateuser(User user) {
		return userdao.save(user);
	}

	public User addUser(int userId, String firstName, String lastName, String email, String userType,
			MultipartFile profile_pic) {
		
		String userprofile=profileservice.uploadpicture(profile_pic);
		User user=new User();
			user.setProfile_pic(userprofile);
			user.setUserId(userId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUserType(userType);
			
//			user.getCredential().setUser(user);
//			user.getCredential().setPassword(passwordEncoder.encode(user.getCredential().getPassword()));
			
			
			userdao.save(user);
			 
		
		return user;
	}


//	public void uploadpicture(MultipartFile file) {
//		try {
//			if(file.isEmpty()) {
//				throw new Exception("This file does not Exist");
//			}
//			Path path=Paths.get("/Users/MASENGESHO/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/springbootfile/src/main/resources/images/"+file.getOriginalFilename());
//			
//			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//		} 
//		catch (Exception e) {
//			e.fillInStackTrace();
//		}
//	}
//
//	public void addUser(User u) {
//		u.getCredential().setUser(u);
//		u.getCredential().setPassword(passwordEncoder.encode(u.getCredential().getPassword()));
//		
//		userdao.save(u);
//	}	
	
}
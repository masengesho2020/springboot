package com.kwiga.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kwiga.Models.User;
import com.kwiga.service.UserService;

@RestController
@RequestMapping("/users")
//Global configuration of cros
//@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userservice;
	
	//adduser method
	//local configuration of cros
//	@CrossOrigin(origins = "http://localhost:8082")
	
		/*
		@PostMapping("/add")
		public ResponseEntity<User>addUser(@RequestBody User user){
			User user1=userservice.Adduser(user);
			
			return new ResponseEntity<>(user1,HttpStatus.CREATED);
		}
		*/
	
	@PostMapping("/add")
	public ResponseEntity<User>addUser(@RequestParam("userId")int userId,
									   @RequestParam("firstName")String firstName,
									   @RequestParam("lastName")String lastName,
									   @RequestParam("email")String email,
									   @RequestParam("userType")String userType,
									   @RequestParam("profile_pic") MultipartFile profile_pic){
		User user=userservice.addUser(userId,firstName,lastName,email,userType,profile_pic);
		
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
		
//	@RequestMapping(value="/add", method=RequestMethod.POST)
//	@ResponseBody void addCourse(@RequestBody User user) {
//		System.out.println(user.toString());
//		
//	}
	
//	// View users
//		@GetMapping("/all")
//		public List<User> getAllusers(){
//			return userservice.getAllusers();
//		}
		
		//View All users
		@RequestMapping(value="/all")
		@ResponseBody List<User>findAll(){
			return userservice.findAll();
		}
		
	// Applying Exception handling here
		@GetMapping(value="/{id}")
		ResponseEntity<User>finduser(@PathVariable Integer id)throws Exception{
			User user=userservice.findUserById(id);
			if(user==null) {
				throw new Exception();
			}
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		
	//Gets user by Id
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable("id") Integer id) {
		return userservice.getUser(id);
	}
	
	//deleteUserByid
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		userservice.deleteUserById(id);
	}	

	//Update user
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody User updateUser(@RequestBody User user) {
		return userservice.updateuser(user);
	}
}
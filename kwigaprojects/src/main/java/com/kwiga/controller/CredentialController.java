package com.kwiga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwiga.Models.Credential;
import com.kwiga.Models.Lesson;
import com.kwiga.dao.CredentialRepository;
import com.kwiga.service.Credentialservice;

@RestController
@RequestMapping("/credentials")
public class CredentialController {
	@Autowired
	Credentialservice credentialservice;
	
//	@GetMapping("/")
//	public String home() {
//		return ("<h1>welcome MASENGESHO</h1>");
//	}
//	
//	@GetMapping("/user")
//	public String user() {
//		return ("<h1>welcome user</h1>");
//	}
//	@GetMapping("/Admin")
//	public String Admin() {
//		return ("<h1>welcome Admin</h1>");
//	}
	
	
	@GetMapping("/all")
	public Iterable<Credential> getscredentials() {
		return credentialservice.getscredentials();
	} 
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody void addCredential(@RequestBody Credential credential) {
		System.out.println(credential.toString());
	}
}

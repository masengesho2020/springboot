package com.kwiga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwiga.Models.Comments;
import com.kwiga.service.CommentService;

@RestController
@RequestMapping("/comments")
public class Commentcontroller {
	
	@Autowired
	private CommentService commentservice;
	
	//Add comments
		@PostMapping("/add")
		public ResponseEntity<Comments>Addcomment(@RequestBody Comments comment){
			Comments comment1=commentservice.Addcomment(comment);
			return new ResponseEntity<>(comment1,HttpStatus.CREATED);
		}
		
	//View comments
		@RequestMapping(value="/all")
		@ResponseBody List<Comments>findcomments(){
			return commentservice.findAll();
		}


}

package com.kwiga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwiga.Models.Course;
import com.kwiga.Models.Lesson;
import com.kwiga.dao.LessonDAO;
import com.kwiga.service.Lessonservice;

@RestController

@RequestMapping("/lessons")
public class LessonController {
	
	@Autowired
	private Lessonservice lessonservice;
	 
	@GetMapping("/all")
	public Iterable<Lesson> getLesson() {
	return lessonservice.getLesson();
	}
	
//	@PostMapping("/")
//	ResponseEntity<Lesson>AddLesson(@RequestBody Lesson lesson){
//		Lesson lesson1=lessonservice.AddLesson(lesson);
//		return new ResponseEntity<>(lesson1,HttpStatus.CREATED);
//	}
	// This is used to return an Object in order to Debugs our project
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody void addLesson(@RequestBody Lesson lesson) {
		System.out.println(lesson.toString());
	}
}

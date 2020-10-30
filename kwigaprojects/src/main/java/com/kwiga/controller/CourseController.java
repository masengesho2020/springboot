package com.kwiga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwiga.Models.Course;
import com.kwiga.service.CourseService;


@RestController
@RequestMapping(value="/courses")
public class CourseController {
	
	@Autowired
	public CourseService courseService;
	
	//Add course
	@PostMapping("/add")
	public ResponseEntity<Course>Addcourse(@RequestBody Course course){
		Course course1=courseService.Addcourse(course);
		return new ResponseEntity<>(course1,HttpStatus.CREATED);
	}
	
//	//View All courses
//	@GetMapping(value="/all")
//	public List<Course> getAllcourses(){
//		return courseService.getAllcourses();
//	}
	
	//View All courses
	@RequestMapping(value="/all")
	@ResponseBody List<Course>findAll(){
		return courseService.findAll();
	}
	
//	@RequestMapping(value="/add", method=RequestMethod.POST)
//	@ResponseBody void addCourse(@RequestBody Course course) {
//		System.out.println(course.toString());
//	}
	
	//Update course
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody Course updateCourse(@RequestBody Course course) {
		return courseService.updatecourse(course);
	}
	
	//Delete course
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
//	@ResponseBody void deleteCourse(@RequestParam("id") long id) {
    @ResponseBody void deleteCourse(@PathVariable("id") long id) {
		courseService.deletecourse(id);
	}	
}

package com.kwiga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Course;
import com.kwiga.Models.Material;
import com.kwiga.dao.CourseDAO;
import com.kwiga.dao.MaterialDao;

@Service
public class CourseService {
	
	@Autowired
	CourseDAO coursedao;

//	public Course Addcourse(Course course) {
//		//System.out.println(course.getCourseDuration().getHours());
//		course.getCourseDuration();
//		return coursedao.save(course);
//	}
	

	public List<Course> findAll() {
		return (List<Course>) coursedao.findAll();
	}

	public void save(Course course) {
		coursedao.save(course);
	}

	public void deletecourse(long id) {
		coursedao.deleteById(id);
	}

	public Course Addcourse(Course course) {
		return coursedao.save(course);
	}

//	public List<Course> getAllcourses() {
//		return (List<Course>) coursedao.findAll();
//	}

	public Course updatecourse(Course course) {
		return coursedao.save(course);
	}
}

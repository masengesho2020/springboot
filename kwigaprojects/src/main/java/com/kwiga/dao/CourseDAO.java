package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Course;

@Repository
public interface CourseDAO extends CrudRepository<Course,Long>{
	public Course findCourseBycourseName(String coursename);
}
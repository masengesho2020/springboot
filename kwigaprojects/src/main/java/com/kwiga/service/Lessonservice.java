package com.kwiga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Lesson;
import com.kwiga.dao.LessonDAO;

@Service
public class Lessonservice {
	
	@Autowired
	private LessonDAO lessondao;

	public Iterable<Lesson> getLesson() {
		return lessondao.findAll();
	}

	public Lesson AddLesson(Lesson lesson) {
		return lessondao.save(lesson);
	}

}

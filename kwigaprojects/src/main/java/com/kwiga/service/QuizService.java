package com.kwiga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Quiz;
import com.kwiga.dao.QuizDAO;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizdao;

	public Quiz AddQuiz(Quiz quiz) {
		return quizdao.save(quiz);
	}

	public Iterable<Quiz> findAll() {
		return quizdao.findAll();
	}

	public void deleteQuiz(Integer id) {
		quizdao.deleteById(id);
		
	}

	public Quiz updateQuiz(Quiz quiz) {
		return quizdao.save(quiz);
	}

}

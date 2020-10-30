package com.kwiga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwiga.Models.Quiz;
import com.kwiga.service.QuizService;

@RestController
@RequestMapping(value = "Quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizservice;
	
	//Add Quiz
		@PostMapping("/add")
		public ResponseEntity<Quiz>AddQuiz(@RequestBody Quiz quiz){
			Quiz quiz1=quizservice.AddQuiz(quiz);
			return new ResponseEntity<>(quiz1,HttpStatus.CREATED);
		}
		
	//View Quizs
			@RequestMapping(value="/all")
			@ResponseBody List<Quiz>findQuiz(){
				return (List<Quiz>) quizservice.findAll();
			}
			
	//Delete Quiz
		@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
		 	@ResponseBody void deleteQuiz(@PathVariable("id") Integer id) {
			quizservice.deleteQuiz(id);
		}
		
	//Update Quiz
		@RequestMapping(value="/update", method=RequestMethod.PUT)
		@ResponseBody Quiz updateQuiz(@RequestBody Quiz quiz) {
				return quizservice.updateQuiz(quiz);
			}

}

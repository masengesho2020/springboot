package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Quiz;

@Repository
public interface QuizDAO extends CrudRepository<Quiz, Integer> {

}

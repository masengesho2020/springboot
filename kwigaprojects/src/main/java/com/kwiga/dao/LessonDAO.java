package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Lesson;

@Repository
public interface LessonDAO extends CrudRepository<Lesson, Long>  {

}

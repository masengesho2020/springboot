package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Course;
import com.kwiga.Models.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{
}

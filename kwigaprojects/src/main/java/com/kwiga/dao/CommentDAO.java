package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Comments;

@Repository
public interface CommentDAO extends CrudRepository<Comments, Integer> {

}

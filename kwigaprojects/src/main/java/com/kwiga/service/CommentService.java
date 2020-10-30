package com.kwiga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Comments;
import com.kwiga.dao.CommentDAO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentdao;

	public Comments Addcomment(Comments comment) {
		return commentdao.save(comment);
	}

	public List<Comments> findAll() {
		return (List<Comments>) commentdao.findAll();
	}

}

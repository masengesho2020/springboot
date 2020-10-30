package com.kwiga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwiga.Models.Material;
import com.kwiga.dao.MaterialDao;

@Service
public class Materialservice {
		
	@Autowired
	MaterialDao materialdao;

	public Material AddMaterial(Material material) {
		return materialdao.save(material);
	}

	public List<Material> findAll() {
		return (List<Material>) materialdao.findAll();
	}

	public void deletematerial(long id) {
		materialdao.deleteById(id);
	}

	public Material updatematerial(Material material) {
		return materialdao.save(material);
	}
}

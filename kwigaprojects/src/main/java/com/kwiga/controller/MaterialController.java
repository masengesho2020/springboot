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

import com.kwiga.Models.Material;
import com.kwiga.service.Materialservice;

@RestController
@RequestMapping(value = "/materials")
public class MaterialController {
		
	@Autowired
	Materialservice materialservice;
	
		//Add Material
			@PostMapping("/add")
			public ResponseEntity<Material>AddMaterial(@RequestBody Material material){
				Material material1=materialservice.AddMaterial(material);
				return new ResponseEntity<>(material1,HttpStatus.CREATED);
			}
		//View Materials
			@RequestMapping(value="/all")
			@ResponseBody List<Material>findmaterials(){
				return materialservice.findAll();
			}
			
		//Delete matrial
			@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
			@ResponseBody void deleteMaterial(@PathVariable("id") long id) {
			materialservice.deletematerial(id);
			}
				
		//Update material
			@RequestMapping(value="/update", method=RequestMethod.PUT)
			@ResponseBody Material updateMaterial(@RequestBody Material material) {
				return materialservice.updatematerial(material);
			}
}

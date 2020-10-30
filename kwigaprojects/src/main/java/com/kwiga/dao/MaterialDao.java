package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Material;

@Repository
public interface MaterialDao extends CrudRepository<Material, Long> {

}

package com.kwiga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwiga.Models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}

package com.timposu.springboot.service;

import org.springframework.data.repository.CrudRepository;

import com.timposu.springboot.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	
}

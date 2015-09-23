package com.timposu.springboot.service;

import org.springframework.data.repository.CrudRepository;

import com.timposu.springboot.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	
}

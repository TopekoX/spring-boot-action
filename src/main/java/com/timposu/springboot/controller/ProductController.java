package com.timposu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timposu.springboot.domain.Product;
import com.timposu.springboot.service.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired ProductRepository productRepository;
	
	@RequestMapping("/halo")
	public String halo(){
		return "Halo Dunia";
	}
	
	@RequestMapping("/product/list")
	public Iterable<Product> allProduct(){
		return productRepository.findAll();
	}
}

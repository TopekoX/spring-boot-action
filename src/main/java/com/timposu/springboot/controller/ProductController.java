package com.timposu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timposu.springboot.domain.Product;
import com.timposu.springboot.service.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired ProductRepository productRepository;
	
	@RequestMapping("/halo")
	public String halo(){
		return "Halo Dunia";
	}
	
	@RequestMapping("/product")
	public Iterable<Product> allProduct(){
		return productRepository.findAll();
	}
        
        @RequestMapping(value = "/product/{id}", method=RequestMethod.GET)
        public Product findById(@PathVariable Long id){
            return productRepository.findOne(id);
        }
}

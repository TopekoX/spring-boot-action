package com.timposu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timposu.springboot.domain.Product;
import com.timposu.springboot.service.ProductRepository;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

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
        
        @RequestMapping(value = "/product", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Product product, HttpServletRequest request, 
                HttpServletResponse response ){
            productRepository.save(product);
            Long newId = product.getId();
            String requestUrl = request.getRequestURL().toString();
            URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, newId);
            response.setHeader("Location", uri.toASCIIString());
        }
        
        @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
        @ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Product product){
            Product px = productRepository.findOne(id);
            if (px == null){
                throw new IllegalStateException("No product id :" + id);
            }
            product.setId(id);
            productRepository.save(product);
        }
        
        @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
            productRepository.delete(id);
        }
}

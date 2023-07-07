package com.nagarro.restapi.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restapi.entities.Product;
import com.nagarro.restapi.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
   
	 @CrossOrigin()
	   @GetMapping("/products")
	   public ResponseEntity<List<Product>> getAllProducts(){
		   return ResponseEntity.ok(productService.getAllProducts());
	   }
        
	
	 @CrossOrigin()
	   @GetMapping("/products/search")
	    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String productName,
	                                                        @RequestParam(required = false) String productBrand,
	                                                        @RequestParam(required = false) String productCode) {
	   
		   List<Product> products = new ArrayList<>();
	        
		   if (productCode!=null) {
			  
	            Product product = productService.findByProductCode(productCode);
	            
	                products.add(product);
	                return ResponseEntity.ok(products);
	            
	        }
		   
		   HashSet<Product>commanProducts=new HashSet<>();
		 
		   if (productName != null) {
	          commanProducts.addAll(productService.findByProductName(productName));
			 
	        }
		 
	        
	        if (productBrand != null) {
	        	if(productName==null) {
	        		
	        		  commanProducts.addAll(productService.findByProductBrand(productBrand));
	        	}
	        	else
	            commanProducts.retainAll(productService.findByProductBrand(productBrand));
	        }
	        
	      
	        products.addAll(commanProducts);
	        return ResponseEntity.ok(products);
	    }
	
  
	 @CrossOrigin()
	 @PostMapping("/products")
	 public ResponseEntity<?>  postProduct(@RequestBody Product product) {
		
		 if(productService.save(product)==null) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<>(HttpStatus.OK);
		
		 
	 }
	
}

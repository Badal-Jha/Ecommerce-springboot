package com.nagarro.restapi.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.restapi.entities.Product;
import com.nagarro.restapi.repository.ProductRepository;

@Service
public class ProductService {

	   @Autowired 
	   ProductRepository productRepo;
	   
	  
	  //save product 
	   public Product save(Product product) {
		   if(productRepo.existsById(product.getProductCode())) {
			   return null;
		   }
		   return productRepo.save(product);
	   }

	   //findProductByProductCode
	   public  Product findByProductCode(String productCode) {
		    return productRepo.findByProductCode(productCode);
	   }
	   
	public List<Product> findByProductName(String productName) {
		return productRepo.findByProductNameContainingIgnoreCase(productName);
	}
	
	public List<Product> findByProductBrand(String productBrand){
		return productRepo.findByProductBrandContainingIgnoreCase(productBrand);
	}
	
	public long countProducts() {
		return productRepo.count();
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
}

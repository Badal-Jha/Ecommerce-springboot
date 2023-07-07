package com.nagarro.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.restapi.entities.Product;
import com.nagarro.restapi.entities.Review;

import com.nagarro.restapi.repository.ReviewRepository;

@Service
public class ReviewService {

	 @Autowired
	 ReviewRepository reviewRepo;
	 @Autowired
	 ProductService productService;
	 
	 public Review addReview(Review review, String productCode){
		 
		 Product product= productService.findByProductCode(productCode);
		 
		 product.getReviews().add(review);
	
		 
		 //we dont have to explicitly save it as we have defined casecade.all in entity
		// productService.save(product);
		 
		 review.setProduct(product);
		 
	    return reviewRepo.save(review);
	 
	   
	 }

	public Review approveReview(Integer reviewId) {
		
		Review review=reviewRepo.findByReviewId(reviewId);
		review.setApproved(true);
		
		return reviewRepo.save(review);
		
	}
	
	public long countReviews() {
		
		List<Review>reviews=reviewRepo.findAll();
		int count=0;
		for(Review r:reviews) {
			if(r.isApproved())count++;
			
		}
		return count;
	}

	public List<Review> getAllReviews() {
		
		return reviewRepo.findAll();
	}
   
	public void rejectReview(int id) {
		
		this.reviewRepo.deleteById(id);
		
	}
}

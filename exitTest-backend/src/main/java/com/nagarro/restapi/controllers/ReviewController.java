package com.nagarro.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restapi.entities.Review;
import com.nagarro.restapi.models.Stat;
import com.nagarro.restapi.services.ProductService;
import com.nagarro.restapi.services.ReviewService;
import com.nagarro.restapi.services.UserService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	
	 @CrossOrigin()
	@GetMapping("/admin/reviews")
	public ResponseEntity<List<Review>> getAllReviews() {
		List<Review>reviews=reviewService.getAllReviews();
		
		return ResponseEntity.ok(reviews);
	}
	
	 @CrossOrigin()
	@PostMapping("/reviews/{id}")
	public ResponseEntity<?> addReview(@RequestBody Review review,@PathVariable("id") String productCode) {
	 
	   review.setProductCode(productCode);
	   System.out.println(review);
		reviewService.addReview(review, productCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	 @CrossOrigin()
	@PatchMapping("/admin/reviews/{id}")
	public ResponseEntity<?> approveReview(@PathVariable("id") Integer reviewId){
		reviewService.approveReview(reviewId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//get all stats
	 @CrossOrigin()
	 @GetMapping("/stats")
	 public Stat getAllCounts() {
		Stat stat=new Stat();
		stat.setCountProducts(productService.countProducts());
		stat.setCountReviews(reviewService.countReviews());
		stat.setCountUsers(userService.countusers());
		
		return stat;
		 
	 }
	 
	 //delete a review
	 
	    @CrossOrigin()
		@DeleteMapping("/admin/reviews/{id}")
		public ResponseEntity<?> rejectReview(@PathVariable("id") Integer reviewId){
		    System.out.println("deleted");
	    	reviewService.rejectReview(reviewId);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
}

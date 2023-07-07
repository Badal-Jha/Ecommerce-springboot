package com.nagarro.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.restapi.entities.Product;
import com.nagarro.restapi.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>{
	public Review findByReviewId(Integer reviewId);
	@Query(value="delete from review where review_id=:reviewId",nativeQuery=true)
	public int deleteByReviewId(@Param("reviewId") Integer reviewId);
}

package com.nagarro.restapi.models;

public class Stat {
    
	private long countUsers;
	private long countReviews;
	private long countProducts;
	
	
	
	public long getCountUsers() {
		return countUsers;
	}
	public void setCountUsers(long countUsers) {
		this.countUsers = countUsers;
	}
	public long getCountReviews() {
		return countReviews;
	}
	public void setCountReviews(long countReviews) {
		this.countReviews = countReviews;
	}
	public long getCountProducts() {
		return countProducts;
	}
	public void setCountProducts(long countPosts) {
		this.countProducts= countPosts;
	}
	
	
}

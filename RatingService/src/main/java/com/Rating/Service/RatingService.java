package com.Rating.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rating.Entity.Rating;


public interface RatingService {
	
	public List<Rating> getAllRatings();
	
	public Rating getRatingById(int ratingId);
	
	public List<Rating> getRatingByUserId(int ratingId);
	
	public Rating createRating(Rating rating);
	

}

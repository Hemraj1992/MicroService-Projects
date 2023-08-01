package com.Rating.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rating.Entity.Rating;
import com.Rating.Repository.RatingServiceRepository;
import com.Rating.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingServiceRepository ratingServiceRepository;
	
	
	@Override
	public List<Rating> getAllRatings() {
		return ratingServiceRepository.findAll();
	}

	@Override
	public Rating getRatingById(int ratingId) {
		return ratingServiceRepository.findById(ratingId).orElseThrow();
	}

	@Override
	public Rating createRating(Rating rating) {
		return ratingServiceRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		return ratingServiceRepository.findByuserId(userId);
	}

}

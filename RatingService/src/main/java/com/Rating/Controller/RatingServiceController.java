package com.Rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rating.Entity.Rating;
import com.Rating.Service.RatingService;

@RestController
@RequestMapping("/Rating")
public class RatingServiceController {
	
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/GetAllRatings")
	public ResponseEntity getAllRatings() {
		return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity getRatingById(@PathVariable ("ratingId") int ratingId) {
		return new ResponseEntity<>(ratingService.getRatingById(ratingId), HttpStatus.OK);
	}
	
	@GetMapping("RatingByUserId/{userId}")
	public ResponseEntity getRatingByUserId(@PathVariable ("userId") int userId) {
		return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
	}

	@PostMapping("/CreateRating")
	public ResponseEntity createRating(@RequestBody Rating rating) {
		return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
	}

}

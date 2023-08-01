package com.Rating.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.Rating.Bean.Hotel;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ratingId")
	private Integer ratingId;
	
	@Column(name = "userId")
	private Integer userId;
	
	
	@Column(name = "hotelId")
	private Integer hotelId;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "feedBack")
	private String feedBack;
	
	@Transient
	private List<Hotel> hotels;

	
	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

}

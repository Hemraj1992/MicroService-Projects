package com.UserService.Beans;

public class Rating {

	private Integer userId;
	private Integer ratingId;
	private Integer hotelId;
	private int rating;
	private String feedBack;
	private Hotel hotel;
	
//	public Rating(Integer userId, Integer ratingId, Integer hotelId, int rating, String feedBack, Hotel hotel) {
//		super();
//		this.userId = userId;
//		this.ratingId = ratingId;
//		this.hotelId = hotelId;
//		this.rating = rating;
//		this.feedBack = feedBack;
//		this.hotel = hotel;
//	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
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

	public String getfeedBack() {
		return feedBack;
	}

	public void setfeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}

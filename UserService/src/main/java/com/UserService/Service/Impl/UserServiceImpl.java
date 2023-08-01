package com.UserService.Service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.Beans.Hotel;
import com.UserService.Beans.Rating;
import com.UserService.Beans.UserBean;
import com.UserService.Entity.UserEntity;
import com.UserService.Exception.ResourceNotFoundException;
import com.UserService.Repository.UserRepositoty;
import com.UserService.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoty userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<UserEntity> getAllTheUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(Integer userId) {
		UserEntity user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Id: " + userId + " Not Found On The Server"));
		int id = user.getUserId();
		
//		try {
			
			Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/Rating/RatingByUserId/"+user.getUserId(), Rating[].class);
//			List<Rating> ratingList = Arrays.asList(ratings);
			
			for(Rating rating : ratings) {
				System.out.println("inside rating");
				Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/Hotel/GetHotel/"+rating.getHotelId(), Hotel.class);
				rating.setHotel(hotel);
				System.out.println("Hotel set in rating");
			}
			
//			ratings.stream().map(rating -> {
//				ResponseEntity<Hotel> rEntity = restTemplate.getForEntity("http://localhost:8002/Hotel/GetHotel/"+rating.getHotelId(), Hotel.class);
//				System.out.println("hotel api status: " + rEntity.getStatusCode());
//				Hotel hotel = rEntity.getBody();
//				rating.setHotel(hotel);
//				return rating;
//			});
			user.setRatings(Arrays.asList(ratings));
			
			
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
		
		
		return user;
		
		
		
	}

	@Override
	public UserEntity createUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

}

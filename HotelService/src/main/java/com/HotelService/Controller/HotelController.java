package com.HotelService.Controller;

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

import com.HotelService.Entity.HotelEntity;
import com.HotelService.Services.HotelService;

@RestController
@RequestMapping("/Hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;

	@GetMapping("/GetAllHotels")
	public ResponseEntity getAllHotels() {
		return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
	}

	@GetMapping("/GetHotel/{hotelId}")
	public ResponseEntity getHotelById(@PathVariable ("hotelId") Integer hotelId) {
		return new ResponseEntity<>(hotelService.getHotelById(hotelId), HttpStatus.OK);
	}

	@PostMapping("/createHotel")
	public ResponseEntity createHotel(@RequestBody HotelEntity hotel) {
		return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
	}
}

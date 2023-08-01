package com.HotelService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Entity.HotelEntity;
import com.HotelService.Exception.ResourceNotFoundException;
import com.HotelService.Repository.HotelRepository;
import com.HotelService.Services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	public HotelRepository hotelRepository;

	@Override
	public List<HotelEntity> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public HotelEntity getHotelById(Integer hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel Id " + hotelId + " not avaliable"));
	}

	@Override
	public HotelEntity createHotel(HotelEntity hotel) {
		return hotelRepository.save(hotel);
	}

}

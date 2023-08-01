
package com.HotelService.Services;

import java.util.List;

import com.HotelService.Entity.HotelEntity;

public interface HotelService {
	
	public List<HotelEntity> getAllHotels();
	
	public HotelEntity getHotelById(Integer hotelId);
	
	public HotelEntity createHotel(HotelEntity hotel);

}

package com.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.Entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{

}

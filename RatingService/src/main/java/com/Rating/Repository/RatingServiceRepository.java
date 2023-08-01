package com.Rating.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Rating.Entity.Rating;


public interface RatingServiceRepository extends JpaRepository<Rating, Integer>{

	public List<Rating> findByuserId(Integer userId);
}

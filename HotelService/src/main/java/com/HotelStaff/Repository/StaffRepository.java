package com.HotelStaff.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelStaff.Entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

}

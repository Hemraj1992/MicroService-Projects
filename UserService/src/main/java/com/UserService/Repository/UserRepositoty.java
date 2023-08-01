package com.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserService.Entity.UserEntity;

public interface UserRepositoty extends JpaRepository<UserEntity, Integer> {

}

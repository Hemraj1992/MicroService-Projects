package com.UserService.Service;


import java.util.List;

import com.UserService.Beans.UserBean;
import com.UserService.Entity.UserEntity;

public interface UserService {

	public List<UserEntity> getAllTheUsers();

	public UserEntity getUserById(Integer userId);

	public UserEntity createUser(UserEntity userEntity);

}

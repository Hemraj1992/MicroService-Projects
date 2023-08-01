package com.UserService.Beans;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserBean {

	public String userName;
	
	public String mobileNumber;
	
	public String gender;
}

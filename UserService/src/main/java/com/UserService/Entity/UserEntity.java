package com.UserService.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.UserService.Beans.Rating;

import lombok.Data;

@Entity
@Data
@Table(name="userDetails")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "password", columnDefinition = "varchar(20) default 'hm1234'")
	private String password;
	
	@Column(name = "role", columnDefinition = "varchar(20) default 'USER'")
	private String role;
	

	@Transient
	private List<Rating> ratings; 
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	

}

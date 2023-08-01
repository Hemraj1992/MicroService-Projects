package com.UserService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UserService.Beans.ApiResponse;
import com.UserService.Beans.UserBean;
import com.UserService.Entity.UserEntity;
import com.UserService.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserServiceController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/Home")
	public String homePage() {
		return "This is home page";
	}
	
	@GetMapping("Login")
	public String loginPage() {
		return "This is login page";
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity getAllTheUsers(){
		return new ResponseEntity<>(userService.getAllTheUsers(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getUser/{Id}")
	@CircuitBreaker(name="HotelRatingBreaker", fallbackMethod = "HotelRatingFallback")
	public ResponseEntity getUserById(@PathVariable ("Id") Integer userId){
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	public ResponseEntity HotelRatingFallback(Integer userId, Exception e) {
		System.out.println("Inside HotelRatingFallback method"+ e.getMessage());
		return new ResponseEntity<>("Return from fallback method: "+e.getMessage(), HttpStatus.PARTIAL_CONTENT);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity createUser(@RequestBody UserEntity userEntity){
		return new ResponseEntity<>(userService.createUser(userEntity), HttpStatus.CREATED);
	}

}

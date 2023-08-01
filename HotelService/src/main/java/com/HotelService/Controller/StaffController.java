package com.HotelService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Staff")
public class StaffController {
	
	@GetMapping
	public List<String> getAllStaff(){
		return  Arrays.asList("Mukesh", "Suresh", "Ram");
	}

}

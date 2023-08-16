package com.kh.toyproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.toyproject.dto.LocationDto;
import com.kh.toyproject.repo.LocationRepo;

@RestController
@RequestMapping("/location")
public class LocationRestController {
	
	@Autowired
	private LocationRepo repo;
	
	@GetMapping("/{city}/{detail}")
	public LocationDto selectByDetail(@PathVariable String city, @PathVariable String detail) {
		return repo.selectByDetail(city, detail);
	}
}

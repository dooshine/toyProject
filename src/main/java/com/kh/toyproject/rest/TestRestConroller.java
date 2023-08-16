package com.kh.toyproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.toyproject.dto.TestDto;
import com.kh.toyproject.repo.TestRepo;

@RestController
@RequestMapping("/test")
public class TestRestConroller {
	@Autowired
	private TestRepo testRepo;
	
	@GetMapping("/")
	public List<TestDto> testList(){
		return testRepo.select();
	}
}

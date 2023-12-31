package com.kh.toyproject.rest;

import com.kh.toyproject.service.KarloService;
import com.kh.toyproject.vo.KarloResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/karlo")
public class KarloRestController {
	
	@Autowired
	private KarloService karloService;
	
	@PostMapping("/")
	public KarloResponseVO genImage(@RequestBody String prompt) throws URISyntaxException {
		return karloService.KarloResponse(prompt);
	}
}

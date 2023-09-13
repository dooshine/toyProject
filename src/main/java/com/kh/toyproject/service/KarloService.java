package com.kh.toyproject.service;

import java.net.URISyntaxException;

import com.kh.toyproject.vo.KarloResponseVO;

public interface KarloService {
	KarloResponseVO KarloResponse(String prompt) throws URISyntaxException;
}

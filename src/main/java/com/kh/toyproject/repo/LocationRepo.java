package com.kh.toyproject.repo;

import java.util.List;

import com.kh.toyproject.dto.LocationDto;

public interface LocationRepo {
	LocationDto selectByDetail(String city, String detail);
	List<String> selectCityList();
	List<String> selectDetailList(String city);
}

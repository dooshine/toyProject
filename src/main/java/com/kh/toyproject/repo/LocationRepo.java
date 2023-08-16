package com.kh.toyproject.repo;

import com.kh.toyproject.dto.LocationDto;

public interface LocationRepo {
	LocationDto selectByDetail(String city, String detail);
}

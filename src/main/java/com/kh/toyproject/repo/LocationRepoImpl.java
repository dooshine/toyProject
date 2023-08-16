package com.kh.toyproject.repo;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.toyproject.dto.LocationDto;

@Repository
public class LocationRepoImpl implements LocationRepo{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public LocationDto selectByDetail(String city, String detail) {
		Map<String, Object> params = new HashMap<>();
		params.put("locationCity", city);
		params.put("locationDetail", detail);
		return sqlSession.selectOne("location.selectByDetail",params);
	}

}

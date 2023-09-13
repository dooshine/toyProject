package com.kh.toyproject.repo;

import com.kh.toyproject.dto.LocationDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LocationRepoImpl implements LocationRepo{
	
	private final SqlSession sqlSession;
	
	public LocationRepoImpl (SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public LocationDto selectByDetail(String city, String detail) {
		Map<String, Object> params = new HashMap<>();
		params.put("locationCity", city);
		params.put("locationDetail", detail);
		return sqlSession.selectOne("location.selectByDetail",params);
	}

	@Override
	public List<String> selectCityList() {
		return sqlSession.selectList("location.selectCityList");
	}

	@Override
	public List<String> selectDetailList(String city) {
		return sqlSession.selectList("location.selectDetailList",city);
	}

}

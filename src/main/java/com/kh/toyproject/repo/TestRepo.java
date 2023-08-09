package com.kh.toyproject.repo;

import com.kh.toyproject.dto.TestDto;

import java.util.List;

public interface TestRepo {
    List<TestDto> select();
    void add(TestDto testDto);

}

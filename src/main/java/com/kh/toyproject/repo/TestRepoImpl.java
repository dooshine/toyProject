package com.kh.toyproject.repo;

import com.kh.toyproject.dto.TestDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepoImpl implements TestRepo {
    private final SqlSession sqlSession;

    public TestRepoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    @Override
    public List<TestDto> select() {
        return sqlSession.selectList("test.select");
    }

    @Override
    public void add(TestDto testDto) {
        sqlSession.insert("test.add", testDto);
    }
}

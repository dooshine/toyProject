package com.kh.toyproject.service;

import com.kh.toyproject.dto.UserDto;

public interface UserService {
//    유저 정보 저장
    public void saveUser(UserDto userDto);
    // 유저 로그인
    public void loginUser();
    // 유저 정보 수정
    public void updateUser();
    // 유저 정보 삭제
    public void deleteUser();
    // 유저 정보 조회
    public void selectUser();
    
}

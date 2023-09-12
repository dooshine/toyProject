package com.kh.toyproject.service;

import com.kh.toyproject.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    // 유저 정보 저장
    @Override
    public void saveUser(UserDto userDto) {
        return;
    }

    // 유저 로그인
    @Override
    public void loginUser() {

    }

    // 유저 정보 수정
    @Override
    public void updateUser() {

    }

    // 유저 정보 삭제
    @Override
    public void deleteUser() {

    }

    // 유저 정보 조회
    @Override
    public void selectUser() {

    }

    // String으로 uuid string 생성 (8-4-4-4-12, 36글자)
    private static String strUUID(String str){
        UUID uuid = UUID.nameUUIDFromBytes(strToByteArr(str));
        return uuid.toString();
    }
    // String으로 byte[] 생성
    private static byte[] strToByteArr(String str){
        byte[] byteArr = new byte[str.length()];
        for(int i=0; i<str.length(); i++){
            byteArr[i] = (byte)str.charAt(i);
        }
        return byteArr;
    }
    
}

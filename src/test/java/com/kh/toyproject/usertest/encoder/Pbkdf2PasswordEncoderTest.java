package com.kh.toyproject.usertest.encoder;

import com.kh.toyproject.service.ChatGptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
public class Pbkdf2PasswordEncoderTest {

    @MockBean
    private ChatGptServiceImpl chatGptServiceImpl;
    
    @Test
    public void pbkdf2PasswordEncoderTest01(){

        // # 인코더 생성
        Pbkdf2PasswordEncoder encoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();

        // # 인코딩
        String result = encoder.encode("myPassword");

        // # 결과확인
        assertTrue(encoder.matches("myPassword", result));
        // assertTrue(encoder.matches("myPassword1", result));
    }
}

package com.kh.toyproject.usertest.encoder;

import com.kh.toyproject.service.ChatGptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
public class Argon2PasswordEncoderTest {
    
    // implementation 'org.bouncycastle:bcprov-jdk15on:1.70' 디펜던시 필요
    @MockBean
    private ChatGptServiceImpl chatGptService;
    @Test
    public void argon2PasswordEncoder(){

        // # 인코더 생성
        Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

        // # 인코딩
        String result = encoder.encode("myPassword");
        String result2 = encoder.encode("myPassword");

        // # 결과확인
        log.debug("========== argon2PasswordEncoder 시작 ==========");
        log.debug("{}", result);
        log.debug("{}", result2);
        assertTrue(encoder.matches("myPassword", result));
    }
}

package com.kh.toyproject.usertest.encoder;

import com.kh.toyproject.service.ChatGptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
public class SCryptPasswordEncoderTest {
    
    @MockBean
    private ChatGptServiceImpl chatGptService;
    
    @Test
    public void sCryptPasswordEncoderTest(){
        
        // # 인코더 생성
        SCryptPasswordEncoder encoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
        
        // # 인코딩
        String result = encoder.encode("myPassword");
        
        // # 결과확인
        assertTrue(encoder.matches("myPassword", result));

    }
}

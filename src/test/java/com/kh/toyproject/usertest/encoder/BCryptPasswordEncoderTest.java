package com.kh.toyproject.usertest.encoder;

import com.kh.toyproject.service.ChatGptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
public class BCryptPasswordEncoderTest {
    
    @MockBean
    private ChatGptServiceImpl chatGptServiceImpl;
    
    @Test
    public void bCryptPasswordEncoderTest01(){
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("myPassword");
        String result2 = encoder.encode("myPassword");
        log.debug("assertTrue 이제 시작한디");
        // assertTrue(encoder.matches("myPasswor", result));
        // assertEquals(encoder.encode("myPassword"), result);
        log.debug("{}",result);
        log.debug("{}",result2);
        log.debug("{}", encoder.matches("myPassword", result));
        log.debug("{}", encoder.matches("myPassword", result2));
    }
}

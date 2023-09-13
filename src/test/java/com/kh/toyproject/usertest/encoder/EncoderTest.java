package com.kh.toyproject.usertest.encoder;

import com.kh.toyproject.service.ChatGptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@Slf4j
@SpringBootTest
public class EncoderTest {

    @MockBean
    private ChatGptServiceImpl chatGptServiceImpl;
    
    @Test
    public void encoderTest01(){
        
        // # 인코더 생성
        // # 인코딩
        // # 결과확인
        
    }
    
}

package com.kh.toyproject.security.encryptor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

@Slf4j
@SpringBootTest
public class EncryptorTest01 {
    
    private static final Logger logger = LoggerFactory.getLogger(EncryptorTest01.class);
    
    // @Test
    public void encryptTest01(){
        
        String salt = KeyGenerators.string().generateKey();
        // BytesEncryptor encryptor =  Encryptors.stronger("password", "salt");
        TextEncryptor encryptor =  Encryptors.text("password", salt);
        String password = encryptor.encrypt("userPassword");
        
        logger.debug("password: {}", password);
        logger.debug("encryptor.decrypt(password): {}", encryptor.decrypt(password));
    }
}

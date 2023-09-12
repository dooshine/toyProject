package com.kh.toyproject.usertest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@Slf4j
@SpringBootTest
public class UUIDTest01 {
        @Test
    public void uuidTest() {
        log.debug("#################### uuidTest ####################");

        UUID uuid1 = UUID.nameUUIDFromBytes(new byte[]{1,2,3,4,5,6});
        String str1 = uuid1.toString();

        UUID uuid2 = UUID.nameUUIDFromBytes(new byte[]{1,2,3,4,5});
        String str2 = uuid2.toString();

        UUID uuid3 = UUID.nameUUIDFromBytes(new byte[]{1,2,3,4,5,6});
        String str3 = uuid3.toString();

        log.debug(str2);
        log.debug(str2);
        log.debug(str2);
        log.debug(str2);
        log.debug(str1);

        boolean isSame = str3.equals(str1);
        log.debug("{}", isSame);

//        log.debug(UUID.nameUUIDFromBytes("abc".toCharArray()));
    }

    private static byte[] strToByteArr(String str){
        byte[] byteArr = new byte[str.length()];
        for(int i=0; i<str.length(); i++){
            byteArr[i] = (byte)str.charAt(i);
        }
        return byteArr;
    }

    // 8-4-4-4-12 (36글자)
    private static String strUUID(String str){
        UUID uuid = UUID.nameUUIDFromBytes(strToByteArr(str));
        return uuid.toString();
    }
}

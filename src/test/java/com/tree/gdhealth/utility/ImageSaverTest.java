package com.tree.gdhealth.utility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 정인호
 * <p>이미지타입의 파일만 선택적으로 저장하는 ImageSaver 클래스를 테스트하는 코드</p>
 */
@Slf4j
@SpringBootTest
class ImageSaverTest {
    @Transactional
    @Test
    void 이미지파일이_저장에_성공한다(){
        //given
        MockMultipartFile imageFile = new MockMultipartFile("mockName", "mockOriginName.png", "image/png", "test".getBytes(StandardCharsets.UTF_8));

        //when
        ImageSaver saver = ImageSaver.saveImage(imageFile);
        File file = new File(saver.getSavedImagePath());

        //then
        log.debug(saver.toString());
        assertEquals(true,file.exists());
        file.delete();
    }

    @Transactional
    @Test
    void 이미지가_아닌_파일은_저장에_실패한다(){
        //given
        MockMultipartFile nonImageFile = new MockMultipartFile("mockName", "mockOriginName.txt", "text/plain", "test".getBytes(StandardCharsets.UTF_8));

        //when & then
        try {
            ImageSaver saver = ImageSaver.saveImage(nonImageFile);
            log.debug(saver.toString());
            File file = new File(saver.getSavedImagePath());
            file.exists();
        }catch (Exception e){
            assertTrue(true);
            return;
        }
        fail();
    }
}
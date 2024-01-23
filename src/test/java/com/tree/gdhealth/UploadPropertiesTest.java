package com.tree.gdhealth;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * @author 정인호
 */
@Slf4j
@SpringBootTest
public class UploadPropertiesTest {
    @Test
    void 업로드경로_파일생성에_성공한다() throws IOException {
        String fileName = "test.txt";
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+fileName);
        log.debug(file.getAbsolutePath());
        file.createNewFile();
        file.delete();

    }
}

package com.tree.gdhealth.utils.pagination;

import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.IntStream;

/**
 * {@link PaginationUriGenerator} 테스트
 * @author 정인호
 */
class PaginationUriGeneratorTest {
    @Test
    void getPaginationObject() {
        PaginationUriGenerator paginationUriGenerator = new PaginationUriGenerator();
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("aReq", "aReq");
        paramMap.add("bReq", "bReq");
        paramMap.add("bReq", "cReq");
        List<PageUri> pageUris= paginationUriGenerator.getPageUriList(5, 17, "/api/test", paramMap);
        pageUris.forEach(System.out::println);
    }

    @Test
    void testIntSteam(){
        IntStream.rangeClosed(10 , 10)
                .filter(page -> page > 0 )
                .limit(10)
                .forEach(System.out::println);
    }
}
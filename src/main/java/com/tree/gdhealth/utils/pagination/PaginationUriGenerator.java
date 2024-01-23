package com.tree.gdhealth.utils.pagination;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/** <P>페이지네이션을 제공하는 컴포넌트</P>
 * @author 정인호
 */
@Component
public class PaginationUriGenerator {
    final int PAGE_OFFSET = 4;

    /**
     * @param requestPage 현재 페이지
     * @param lastPage 마지막페이지
     * @param path URL경로
     * @param paramMap 추가할 쿼리스트링 멀티뷰맵
     * @return page번호와 uri가 든리스트
     */
    public List<PageUri> getPageUriList(int requestPage, int lastPage, String path, MultiValueMap<String,String> paramMap){
        List<PageUri> pageUriList = new ArrayList<>();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.path(path).queryParams(paramMap);

        IntStream.rangeClosed(requestPage - PAGE_OFFSET, lastPage)
                .limit(PAGE_OFFSET*2+1)
                .filter(page -> page > 0 )
                .mapToObj(page -> new PageUri(page, uriComponentsBuilder.replaceQueryParam("requestPage", page).toUriString()))
                .forEach(pageUriList::add);
        return pageUriList;
    }
}

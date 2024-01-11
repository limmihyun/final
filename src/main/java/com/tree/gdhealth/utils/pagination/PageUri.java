package com.tree.gdhealth.utils.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**<p> 페이지네이션 제공을 위한 util vo</p>
 * @author 정인호
 */
@Getter
@ToString
@AllArgsConstructor
public class PageUri {
    private final int page;
    private final String uri;
}

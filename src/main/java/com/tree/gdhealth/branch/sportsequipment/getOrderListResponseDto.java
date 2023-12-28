package com.tree.gdhealth.branch.sportsequipment;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Builder
@Data
public class getOrderListResponseDto {
    private boolean isOnlyWaitingList;
    private int rowPerPage;
    private int requestPage;
    private int lastPage;
    private List<Map<String,Object>> orderList;
    private List<Map<String,Object>> paginationURIList;
}

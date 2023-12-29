package com.tree.gdhealth.branch.sportsequipment;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
public interface IBranchSportsEquipmentService {
    getOrderListResponseDto getOrderListResponseDto(
            int branchNo,
            int requestPage,
            boolean isOnlyWaitingList);

    boolean addOrder(SportsEquipmentOrderAddDto dto);
}

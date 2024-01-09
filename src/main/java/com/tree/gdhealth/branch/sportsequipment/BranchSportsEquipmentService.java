package com.tree.gdhealth.branch.sportsequipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchSportsEquipmentService {
    final BranchSportsEquipmentMapper mapper;


    public getOrderListResponseDto getOrderListResponseDto(
            Integer branchNo,
            int requestPage,
            boolean isOnlyWaitingList) {

        int rowPerPage = 10;
        int beginRow = (requestPage - 1) * rowPerPage;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("branchNo", branchNo);
        paramMap.put("beginRow", beginRow);
        paramMap.put("rowPerPage", rowPerPage);
        paramMap.put("isOnlyWaitingList", isOnlyWaitingList);

        return getOrderListResponseDto.builder()
                .requestPage(requestPage)
                .isOnlyWaitingList(isOnlyWaitingList)
                .rowPerPage(rowPerPage)
                .orderList(mapper.getOrderList(paramMap))
                .lastPage(mapper.getOrderListLastPage(paramMap))
                .build();
    }
    @Transactional
    public boolean addOrder(SportsEquipmentOrderAddDto dto) {
        int affectedRows = mapper.addOrder(dto);
        return affectedRows == 1;

    }

    public Map<String, Object> getOrderOne(Integer orderNo) {
        return mapper.getOrderOne(orderNo);
    }

    public boolean changeOrderStatus(Integer orderNo, String changeOrderStatus) {
        int affectedRows = mapper.changeOrderStatus(orderNo, changeOrderStatus);

        return affectedRows == 1;
    }
}

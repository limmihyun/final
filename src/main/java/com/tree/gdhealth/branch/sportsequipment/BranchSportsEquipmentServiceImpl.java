package com.tree.gdhealth.branch.sportsequipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchSportsEquipmentServiceImpl implements IBranchSportsEquipmentService {
    final BranchSportsEquipmentMapper mapper;


    @Override
    public getOrderListResponseDto getOrderListResponseDto(
            int branchNo,
            int requestPage,
            boolean isOnlyWaitingList) {

        int rowPerPage = 10;
        int beginRow = (requestPage - 1) * rowPerPage;

        Map<String, Object> paramMap = Map.of(
                "branchNo", branchNo,
                "beginRow", beginRow,
                "rowPerPage", rowPerPage,
                "isOnlyWaitingList", isOnlyWaitingList);

        return getOrderListResponseDto.builder()
                .requestPage(requestPage)
                .isOnlyWaitingList(isOnlyWaitingList)
                .rowPerPage(rowPerPage)
                .orderList(mapper.getOrderList(paramMap))
                .lastPage(mapper.getOrderListLastPage(paramMap))
                .build();
    }
}

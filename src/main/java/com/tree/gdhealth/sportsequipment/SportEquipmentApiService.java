package com.tree.gdhealth.sportsequipment;

import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddDto;
import com.tree.gdhealth.sportsequipment.dto.getOrderListResponseDto;
import com.tree.gdhealth.vo.SportsEquipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**<p>sportsEquipment domain영역을 담담하는 service </p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SportEquipmentApiService {
    private final SportsEquipmentApiMapper sportsEquipmentApiMapper;

    public List<SportsEquipment> getSportsEquipmentList() {
        return sportsEquipmentApiMapper.selectSportsEquipmentAll();
    }

    public SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo) {
        return sportsEquipmentApiMapper.selectSportsEquipmentOne(sportsEquipmentNo);
    }

    public Map<String, Object> getSportsEquipmentOrderOne(Integer orderNo) {
        return sportsEquipmentApiMapper.selectSportsEquipmentOrderOneByOrderNo(orderNo);
    }

    public getOrderListResponseDto getSportsEquipmentOrderList(
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
                .orderList(sportsEquipmentApiMapper.selectSportsEquipmentOrderAll(paramMap))
                .lastPage(sportsEquipmentApiMapper.countSportsEquipmentOrderListLastPage(paramMap))
                .build();
    }

    @Transactional
    public boolean addSportsEquipmentOrder(SportsEquipmentOrderAddDto dto) {
        int affectedRows = sportsEquipmentApiMapper.insertSportsEquipmentOrder(dto);
        return affectedRows == 1;
    }

    public boolean changeSportsEquipmentOrderStatus(Integer orderNo, String changeOrderStatus) {
        int affectedRows = sportsEquipmentApiMapper.updateSportsEquipmentOrderStatus(orderNo, changeOrderStatus);

        return affectedRows == 1;
    }
}

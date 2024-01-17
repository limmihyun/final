package com.tree.gdhealth.sportsequipment;

import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddRequest;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderInformation;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderRetrieveCriteria;
import com.tree.gdhealth.vo.SportsEquipment;
import com.tree.gdhealth.vo.SportsEquipmentImg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**<p>sportsEquipment domain영역을 담담하는 service </p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SportsEquipmentApiService {
    private final SportsEquipmentApiMapper sportsEquipmentApiMapper;

    public List<SportsEquipment> getSportsEquipmentList() {

        return sportsEquipmentApiMapper.selectSportsEquipmentAll();
    }

    public SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo) {

        return sportsEquipmentApiMapper.selectSportsEquipmentOne(sportsEquipmentNo);
    }

    public SportsEquipmentOrderInformation getSportsEquipmentOrderOne(Integer orderNo) {

        return sportsEquipmentApiMapper.selectSportsEquipmentOrderOneByOrderNo(orderNo);
    }

    public List<SportsEquipmentOrderInformation> getSportsEquipmentOrderList(SportsEquipmentOrderRetrieveCriteria criteria){

        return sportsEquipmentApiMapper.selectSportsEquipmentOrderListByCriteria(criteria);
    }

    public int getSportsEquipmentOrderListLastPage(SportsEquipmentOrderRetrieveCriteria criteria) {

        return sportsEquipmentApiMapper.countSportsEquipmentOrderListLastPage(criteria);
    }

    @Transactional
    public boolean addSportsEquipmentOrder(SportsEquipmentOrderAddRequest reqDto) {

        int affectedRows = sportsEquipmentApiMapper.insertSportsEquipmentOrder(reqDto);

        return affectedRows == 1;
    }

    @Transactional
    public boolean changeSportsEquipmentOrderStatus(Integer orderNo, String changeOrderStatus) {

        int affectedRows = sportsEquipmentApiMapper.updateSportsEquipmentOrderStatus(orderNo, changeOrderStatus);

        return affectedRows == 1;
    }

    public String getSportsEquipmentImagePath(int sportsEquipmentNo) {
        return Optional.ofNullable(sportsEquipmentApiMapper.selectSportsEquipmentImage(sportsEquipmentNo)).map(SportsEquipmentImg::getSportsEquipmentImgFileName).orElse(null);

    }
}

package com.tree.gdhealth.sportsequipment;

import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddRequestDto;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderInformation;
import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderRetrieveCriteria;
import com.tree.gdhealth.vo.SportsEquipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
//@autor 정인호

@Mapper
public interface SportsEquipmentApiMapper {
    List<SportsEquipment> selectSportsEquipmentAll();
    SportsEquipment selectSportsEquipmentOne(int sportsEquipmentNo);

    List<SportsEquipmentOrderInformation> selectSportsEquipmentOrderListByCriteria(SportsEquipmentOrderRetrieveCriteria criteria);

    int countSportsEquipmentOrderListLastPage(SportsEquipmentOrderRetrieveCriteria criteria);

    int insertSportsEquipmentOrder(SportsEquipmentOrderAddRequestDto dto);

    Map<String, Object> selectSportsEquipmentOrderOneByOrderNo(@Param("orderNo") Integer orderNo);

    int updateSportsEquipmentOrderStatus(@Param("orderNo") Integer orderNo, @Param("changeOrderStatus") String changeOrderStatus);
}

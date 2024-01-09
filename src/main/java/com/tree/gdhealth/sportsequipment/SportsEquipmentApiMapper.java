package com.tree.gdhealth.sportsequipment;

import com.tree.gdhealth.sportsequipment.dto.SportsEquipmentOrderAddDto;
import com.tree.gdhealth.vo.SportsEquipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SportsEquipmentApiMapper {
    List<SportsEquipment> selectSportsEquipmentAll();
    SportsEquipment selectSportsEquipmentOne(int sportsEquipmentNo);

    List<Map<String, Object>> selectSportsEquipmentOrderAll(Map<String, Object> paramMap);

    int countSportsEquipmentOrderListLastPage(Map<String, Object> paramMap);

    int insertSportsEquipmentOrder(SportsEquipmentOrderAddDto dto);

    Map<String, Object> selectSportsEquipmentOrderOneByOrderNo(@Param("orderNo") Integer orderNo);

    int updateSportsEquipmentOrderStatus(@Param("orderNo") Integer orderNo, @Param("changeOrderStatus") String changeOrderStatus);
}

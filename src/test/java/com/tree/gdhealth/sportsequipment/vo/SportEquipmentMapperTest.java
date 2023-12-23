package com.tree.gdhealth.sportsequipment.vo;

import org.apache.ibatis.annotations.Mapper;

/**
 * vo 의 db 연동성 유닛테스트를 위한 테스트 매퍼
 * @author 정인호
 */
@Mapper
public interface SportEquipmentMapperTest {
    int insertSportsEquipment(SportsEquipment sportsEquipment);
    SportsEquipment findSportsEquipmentByNo(int sportEquipmentNo);

    int insertSportsEquipmentOrder(SportsEquipmentOrder sportsEquipmentOrder);
    SportsEquipmentOrder findSportsEquipmentOrderByNo(int sportEquipmentOrderNo);

}

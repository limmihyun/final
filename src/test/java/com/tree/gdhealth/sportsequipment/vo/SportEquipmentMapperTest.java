package com.tree.gdhealth.sportsequipment.vo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportEquipmentMapperTest {
    int insertSportsEquipment(SportsEquipment sportsEquipment);
    SportsEquipment findSportEquipmentByNo(Integer sportEquipmentNo);

}

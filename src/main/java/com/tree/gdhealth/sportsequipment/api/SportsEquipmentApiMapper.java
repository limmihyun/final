package com.tree.gdhealth.sportsequipment.api;

import com.tree.gdhealth.vo.SportsEquipment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportsEquipmentApiMapper {
    List<SportsEquipment> getSportsEquipmentList();
    SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo);
}

package com.tree.gdhealth.sportsequipment.api;

import com.tree.gdhealth.vo.SportsEquipment;

import java.util.List;

public interface ISportsEquipmentApiService {
    List<SportsEquipment> getSportsEquipmentList();
    SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo);
}

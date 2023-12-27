package com.tree.gdhealth.sportsequipment.api;

import com.tree.gdhealth.sportsequipment.vo.SportsEquipment;

import java.util.List;

public interface ISportsEquipmentApiService {
    List<SportsEquipment> getSportsEquipmentList();
    SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo);
}

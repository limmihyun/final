package com.tree.gdhealth.sportsequipment.api;

import com.tree.gdhealth.sportsequipment.vo.SportsEquipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SportEquipmentApiServiceImpl implements ISportsEquipmentApiService{
    private final SportsEquipmentApiMapper mapper;

    @Override
    public List<SportsEquipment> getSportsEquipmentList() {
        return mapper.getSportsEquipmentList();
    }

    @Override
    public SportsEquipment getSportsEquipmentOne(int sportsEquipmentNo) {
        return mapper.getSportsEquipmentOne(sportsEquipmentNo);
    }
}

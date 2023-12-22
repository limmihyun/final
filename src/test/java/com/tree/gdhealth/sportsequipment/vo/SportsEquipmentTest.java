package com.tree.gdhealth.sportsequipment.vo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 정인호
 */
@Slf4j
@SpringBootTest
class SportsEquipmentTest {
    @Autowired
    SportEquipmentMapperTest mapper;

    @Transactional
    @Test
    void SportEquipmentVo가_DB에_입력되고_조회된다(){
        //given
        SportsEquipment inVo = SportsEquipment.builder()
                .itemPrice(500).itemName("testName").note("testNote").build();
        SportsEquipment outVo = null;

        //when
        mapper.insertSportsEquipment(inVo);
        outVo = mapper.findSportEquipmentByNo(inVo.getSportEquipmentNo());

        //then
        log.debug(outVo.toString());
        assertEquals(outVo.getSportEquipmentNo(), inVo.getSportEquipmentNo());

    }

}
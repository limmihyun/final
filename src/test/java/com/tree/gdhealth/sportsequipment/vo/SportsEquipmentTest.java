package com.tree.gdhealth.sportsequipment.vo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**<p>Vo와 마이바티스간의 타입 안정성 확인을 위한 테스트</p>
 * @author 정인호
 */
@Slf4j
@SpringBootTest
class SportsEquipmentTest {
    @Autowired
    SportEquipmentMapperTest mapper;

    @Transactional
    @Test
    void SportsEquipmentVo가_DB에_입력되고_조회된다(){
        //given
        SportsEquipment inVo = SportsEquipment.builder()
                .itemPrice(500).itemName("testName").note("testNote").build();
        SportsEquipment outVo;

        //when
        mapper.insertSportsEquipment(inVo);
        outVo = mapper.findSportsEquipmentByNo(inVo.getSportsEquipmentNo());

        //then
        log.debug(outVo.toString());
        assertEquals(outVo.getSportsEquipmentNo(), inVo.getSportsEquipmentNo());

    }

    /**
     * 시드 데이터로 테스트를 수행하므로 //given 의 해당 데이터가 변경되면 테스트가 실패할 우려가 있습니다.
     */
    @Transactional
    @Test
    void SportsEquipmentOrderVo가_DB에_입력되고_조회된다(){
        //given
        SportsEquipmentOrder insertVo = SportsEquipmentOrder.builder()
                .sportsEquipmentNo(1)
                .employeeOrderer(2)
                .branchNo(2)
                .quantity(1)
                .totalPrice(1240000)
                .employeeApprover(1)
                .orderStatus(OrderStatus.WAITING).build();

        SportsEquipmentOrder selectVo;

        //when
        int affectedRows = mapper.insertSportsEquipmentOrder(insertVo);
        selectVo = mapper.findSportsEquipmentOrderByNo(insertVo.getOrderNo());
        insertVo.setCreatedate(selectVo.getCreatedate());
        insertVo.setUpdatedate(selectVo.getUpdatedate());

        //then
        log.debug(selectVo.toString());
        assertEquals(1, affectedRows);
        assertEquals(insertVo.getOrderNo(), selectVo.getOrderNo());
        assertEquals(selectVo, insertVo);
    }

}
package com.tree.gdhealth.branch.sportsequipment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Mapper
public interface BranchSportsEquipmentMapper {
    List<Map<String, Object>> getOrderList(Map<String, Object> paramMap);

    int getOrderListLastPage(Map<String, Object> paramMap);

    int addOrder(SportsEquipmentOrderAddDto dto);

    Map<String, Object> getOrderOne(Integer orderNo);

    int changeOrderStatus(@Param("orderNo") Integer orderNo, @Param("changeOrderStatus") String changeOrderStatus);
}

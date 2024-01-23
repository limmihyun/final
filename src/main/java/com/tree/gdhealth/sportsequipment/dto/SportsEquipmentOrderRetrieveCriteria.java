package com.tree.gdhealth.sportsequipment.dto;

import lombok.Builder;
import lombok.Getter;

/**<p>물품주문의 조회조건을 담은 객체</p>
 * @author 정인호
 */
@Builder
@Getter
public class SportsEquipmentOrderRetrieveCriteria {
    private Integer branchNo;
    private Boolean isOnlyWaitingList;
    private Integer requestPage;
    private Integer rowPerPage;

    public Integer getBeginRow(){
        return (requestPage -1)* rowPerPage ;
    }
}

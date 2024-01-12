package com.tree.gdhealth.sportsequipment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

/**
 * @author 정인호
 */
public record SportsEquipmentOrderAddRequest(
        @Positive int employeeOrderer,
        @Positive int branchNo,
        @NotNull(message = "발주물품을 선택해야합니다") Integer sportsEquipmentNo,
        @Positive(message = "발주할 수량은 양수여야 합니다.")
        @NotNull(message = "발주할 수량이 없어서는 안됩니다.") Integer quantity,
        @Positive Integer employeeApprover
){}

package com.tree.gdhealth.branch.sportsequipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchSportsEquipmentServiceImpl implements IBranchSportsEquipmentService{
    final BranchSportsEquipmentMapper branchSportsEquipmentMapper;

}

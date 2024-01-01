package com.tree.gdhealth.branch.programcalendar.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author 정인호
 */

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchProgramDateApiService {
    private final BranchProgramDateApiMapper mapper;

    public Map<String, Object> getBranchProgramDate(LocalDate date, int branchNo) {
        return mapper.getBranchProgramDate(date, branchNo);
    }
}

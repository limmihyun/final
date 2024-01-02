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
    @Transactional
    public boolean changeManager(int programDateNo, int managerNo) {
        //confirm if exist
        int foundRow = mapper.selectManager(programDateNo, managerNo);
        int result = 0;
        if(foundRow == 1){
            // if is update
            result = mapper.changeManager(programDateNo, managerNo);
        }else {
            // or insert
            result = mapper.insertManager(programDateNo, managerNo);
        }
        return result == 1;
    }
}

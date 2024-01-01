package com.tree.gdhealth.branch.programcalendar.api;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramDate;
import com.tree.gdhealth.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class BranchProgramDateApiController {
    private final BranchProgramDateApiService service;

    @GetMapping("/api/v1/BranchProgramDate/{date}")
    public Map<String,Object> getBranchProgramDate(@PathVariable LocalDate date,
                                            @RequestParam("branchNo") int branchNo) {
        return service.getBranchProgramDate(date, branchNo);
    }
}

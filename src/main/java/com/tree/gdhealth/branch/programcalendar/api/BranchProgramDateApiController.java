package com.tree.gdhealth.branch.programcalendar.api;

import com.tree.gdhealth.branch.programcalendar.vo.BranchProgramDate;
import com.tree.gdhealth.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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

    //TODO dto로 변경하기
    @PostMapping("/api/v1/BranchProgramDate/changeManager")
    public ResponseEntity changeManager(@RequestBody Map<String, Object> param){
        int managerNo = Integer.parseInt(param.get("managerNo").toString());
        int programDateNo = Integer.parseInt(param.get("programDateNo").toString());
        boolean result = service.changeManager(programDateNo, managerNo);
        return (result)? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}

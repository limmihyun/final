package com.tree.gdhealth.program;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

/**<p>프로그램 도메인에 대한 REST Api Controller</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class ProgramRestApiController {
    private final ProgramApiService service;
    @GetMapping("/api/v1/programDate/{date}")
    public Map<String,Object> getBranchProgramDate(@PathVariable LocalDate date,
                                                   @RequestParam("branchNo") int branchNo) {
        return service.getBranchProgramDate(date, branchNo);
    }

    @PostMapping("/api/v1/programDate/changeManager")
    public ResponseEntity changeManager(@RequestBody Map<String, Object> param){
        int managerNo = Integer.parseInt(param.get("managerNo").toString());
        int programDateNo = Integer.parseInt(param.get("programDateNo").toString());
        boolean result = service.changeManager(programDateNo, managerNo);
        return (result)? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


}

package com.tree.gdhealth.program;

import com.tree.gdhealth.utils.ResponseEntityGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**<p>프로그램 도메인에 대한 REST Api Controller</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class ProgramRestApiController {
    private final ProgramApiService service;
    private final ResponseEntityGenerator responseEntityGenerator;
    @GetMapping("/api/v1/programDate/{date}")
    public ResponseEntity<Object> getBranchProgramDate(@PathVariable LocalDate date, @RequestParam("branchNo") int branchNo) {

        return responseEntityGenerator.respGET(service.getBranchProgramDate(date, branchNo));
    }

    /**<p>지점의 프로그램매니저를변경(또는 추가)</p>
     */
    @PostMapping("/api/v1/programDate/changeManager")
    public ResponseEntity<Object> changeManager(@RequestParam("managerNo") int managerNo, @RequestParam("programDateNo") int programDateNo){
        boolean result = service.changeManager(programDateNo, managerNo);
        return (result)? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


}

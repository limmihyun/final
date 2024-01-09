package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**<p>지점도메인의 RestApiController</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class BranchRestApiController {
    private final BranchApiService service;

    @GetMapping("/api/v1/branch/{branchNo}")
    public Branch getBranchOne(@PathVariable int branchNo) {
        return service.getBranchOne(branchNo);
    }

    @GetMapping("/api/v1/branch/list")
    public List<Branch> getBranchList(){
        return service.getBranchList();
    }


}

package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.branch.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequiredArgsConstructor
@RestController
public class BranchApiController {
    private final BranchApiService service;

    @GetMapping("/api/v1/branch/{branchNo}")
    public Branch getBranchOne(@PathVariable int branchNo) {
        return service.getBranchOne(branchNo);
    }
}

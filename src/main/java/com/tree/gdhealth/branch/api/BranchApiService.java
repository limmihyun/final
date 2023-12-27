package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchApiService {
    private final BranchApiMapper mapper;

    public Branch getBranchOne(int branchNo) {
        return mapper.getBranchOne(branchNo);
    }
}

package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.branch.dto.BranchRetrieveCriteria;
import com.tree.gdhealth.utils.exception.TooManyResultsException;
import com.tree.gdhealth.vo.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**지점 api service
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BranchApiService {
    private final BranchApiMapper mapper;

    public Branch getBranchOneByBranchNo(int branchNo)throws TooManyResultsException {
        List<Branch> dtoList = mapper.selectBranchListByCriteria(BranchRetrieveCriteria.branchNo(branchNo));
        if(dtoList.size() > 1) {
            throw new TooManyResultsException("1개를 조회하려했으나 2개 이상이 조회되었습니다. 값 ="+ dtoList.toString());
        }
        return dtoList.isEmpty()? null : dtoList.get(0);
    }

    public List<Branch> getBranchListAll() {
        return mapper.selectBranchListByCriteria(BranchRetrieveCriteria.none());
    }
}

package com.tree.gdhealth.branch.dto;

import lombok.Getter;
import lombok.ToString;

/**<p>employeeApi의 조회조건을 담는 객체</p>
 * @author 정인호
 */
@ToString
@Getter
public class BranchRetrieveCriteria {
    private Boolean isHeadOffice;
    private Integer branchNo;

    private BranchRetrieveCriteria(){}

    /*정적 팩토리 메서드*/
    public static BranchRetrieveCriteria none(){
        return new BranchRetrieveCriteria();
    }
    public static BranchRetrieveCriteria isHeadOffice(boolean isHeadOffice){
        BranchRetrieveCriteria criteria = new BranchRetrieveCriteria();
        criteria.setIsHeadOffice(isHeadOffice);
        return criteria;
    }
    public static BranchRetrieveCriteria branchNo(int branchNo){
        BranchRetrieveCriteria criteria = new BranchRetrieveCriteria();
        criteria.setBranchNo(branchNo);
        return criteria;
    }

    /*setter*/
    private void setIsHeadOffice(Boolean isHeadOffice) {
        this.isHeadOffice = isHeadOffice;
    }

    private void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

}

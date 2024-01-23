package com.tree.gdhealth.branch.dto;

import lombok.Getter;
import lombok.ToString;

/**<p>employeeApi의 조회조건을 담는 객체</p>
 * <p>조건(본사여부, 지점번호)가 배타적이기 때문에 정적 팩토리 메서드로 생성자를 대체했습니다.</p>
 * @author 정인호
 */
@ToString
@Getter
public class BranchRetrieveCriteria {
    private Boolean isHeadOffice;
    private Integer branchNo;

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

    private BranchRetrieveCriteria(){}

    /*은닉된 setter*/
    private void setIsHeadOffice(Boolean isHeadOffice) {
        this.isHeadOffice = isHeadOffice;
    }

    private void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

}

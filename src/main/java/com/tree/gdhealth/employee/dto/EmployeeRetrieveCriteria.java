package com.tree.gdhealth.employee.dto;

import lombok.Getter;
import lombok.ToString;

/**<p>employeeApi의 조회조건을 담는 객체</p>
 * @author 정인호
 */
@ToString
@Getter
public class EmployeeRetrieveCriteria {
    private Boolean isHeadOffice;
    private Integer branchNo;
    private EmployeeRetrieveCriteria(){

    }
    public static EmployeeRetrieveCriteria none(){
        return new EmployeeRetrieveCriteria();
    }
    public static EmployeeRetrieveCriteria isHeadOffice(){
        EmployeeRetrieveCriteria criteria = new EmployeeRetrieveCriteria();
        criteria.setHeadOffice(Boolean.TRUE);
        return criteria;
    }
    public static EmployeeRetrieveCriteria branchNo(int branchNo){
        EmployeeRetrieveCriteria criteria = new EmployeeRetrieveCriteria();
        criteria.setBranchNo(branchNo);
        return criteria;
    }

    /*setter*/
    private void setHeadOffice(Boolean headOffice) {
        isHeadOffice = headOffice;
    }

    private void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

}

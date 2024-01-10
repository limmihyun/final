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
    private Integer employeeNo;

    private EmployeeRetrieveCriteria(){}

    /*정적 팩토리 메서드*/
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
    public static EmployeeRetrieveCriteria employeeNo(int employeeNo){
        EmployeeRetrieveCriteria criteria = new EmployeeRetrieveCriteria();
        criteria.setEmployeeNo(employeeNo);
        return criteria;
    }

    /*setter*/
    private void setHeadOffice(Boolean headOffice) {
        isHeadOffice = headOffice;
    }

    private void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

    private void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }
}

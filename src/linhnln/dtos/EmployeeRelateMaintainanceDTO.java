/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author Liam Nguyen
 */
public class EmployeeRelateMaintainanceDTO implements Serializable {
    private String employeeName, devName, requirementContent, repairtContent, result, staffName;
    private Timestamp requirementTime, repairEndDate;
    
    public EmployeeRelateMaintainanceDTO(String employeeName,String devName, String requirementContent, String repairtContent, String result, String staffName, Timestamp requirementTime, Timestamp repairEndDate) {
        this.employeeName = employeeName;
        this.devName = devName;
        this.requirementContent = requirementContent;
        this.repairtContent = repairtContent;
        this.result = result;
        this.staffName = staffName;
        this.requirementTime = requirementTime;
        this.repairEndDate = repairEndDate;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(employeeName);
        v.add(devName);
        v.add(requirementTime);
        v.add(requirementContent);
        v.add(repairEndDate);
        v.add(repairtContent);
        v.add(result);
        v.add(staffName);
        return v;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRequirementContent() {
        return requirementContent;
    }

    public void setRequirementContent(String requirementContent) {
        this.requirementContent = requirementContent;
    }

    public String getRepairtContent() {
        return repairtContent;
    }

    public void setRepairtContent(String repairtContent) {
        this.repairtContent = repairtContent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Timestamp getRequirementTime() {
        return requirementTime;
    }

    public void setRequirementTime(Timestamp requirementTime) {
        this.requirementTime = requirementTime;
    }

    public Timestamp getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(Timestamp repairEndDate) {
        this.repairEndDate = repairEndDate;
    }
    
    
    
}

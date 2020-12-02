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
public class DeviceDepartmentRelateMaintainanceDTO implements Serializable {
    private int depID, devID, repID;
    private String devName, requirementContent, repairContent, result, depName, staffName;
    private Timestamp requirementTime, repairStartDate, repairEndDate;
    
    //list all device and its history
    public DeviceDepartmentRelateMaintainanceDTO(int devID, int repID, String devName, String requirementContent, String repairContent, String result, String depName, Timestamp repairStartDate, Timestamp repairEndDate, String staffName) {
        this.devID = devID;
        this.repID = repID;
        this.devName = devName;
        this.requirementContent = requirementContent;
        this.repairContent = repairContent;
        this.result = result;
        this.depName = depName;
        this.repairStartDate = repairStartDate;
        this.repairEndDate = repairEndDate;
        this.staffName = staffName;
    }
   
    //find to show device in textfield
    public DeviceDepartmentRelateMaintainanceDTO(int depID, int devID, String repairContent, String result, String staffName) {
        this.depID = depID;
        this.devID = devID;
        this.repairContent = repairContent;
        this.result = result;
        this.staffName = staffName;
    }
    
    //get all dto from textfield and update from view for Staff view mode 
    public DeviceDepartmentRelateMaintainanceDTO(int depID, int repID, String repairContent, String result, Timestamp repairStartDate, Timestamp repairEndDate, String staffName) {
        this.depID = depID;
        this.repID = repID;
        this.repairContent = repairContent;
        this.result = result;
        this.repairStartDate = repairStartDate;
        this.repairEndDate = repairEndDate;
        this.staffName = staffName;
    }
    
    //find to modify table
    public DeviceDepartmentRelateMaintainanceDTO(String repairContent, String result, String depName, Timestamp repairStartDate, Timestamp repairEndDate) {
        this.repairContent = repairContent;
        this.result = result;
        this.depName = depName;
        this.repairStartDate = repairStartDate;
        this.repairEndDate = repairEndDate;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(repID);
        v.add(depName);
        v.add(devID);
        v.add(devName);
        v.add(requirementContent);
        v.add(repairContent);
        v.add(repairStartDate);
        v.add(repairEndDate);
        v.add(result);
        v.add(staffName);
        return v;
    }
    
    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public int getDevID() {
        return devID;
    }

    public void setDevID(int devID) {
        this.devID = devID;
    }

    public String getRequirementContent() {
        return requirementContent;
    }

    public int getRepID() {
        return repID;
    }

    public void setRepID(int repID) {
        this.repID = repID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    

    public void setRequirementContent(String requirementContent) {
        this.requirementContent = requirementContent;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getRequirementTime() {
        return requirementTime;
    }

    public void setRequirementTime(Timestamp requirementTime) {
        this.requirementTime = requirementTime;
    }

    public Timestamp getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Timestamp repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public Timestamp getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(Timestamp repairEndDate) {
        this.repairEndDate = repairEndDate;
    }
    
    
}

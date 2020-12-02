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
public class MaintainanceDTO implements Serializable {
    private int empID, devID;
    private String requirementContent, repairContent, result;
    private Timestamp requirementTime , repairStartDate, repairEndDate;
    
    //người dùng: search TB => thông báo thiết bị cần sửa chửa thì nhập ID thiết bị
    //nhập phòng mình làm việc, nếu phòng mình k có thiết bị đó thì JOP thông báo ra null
    
    //Nhân viên sửa chửa: search TB => đổi vị trí (setDepID), Update repairContent
    //xem lịch chỉnh sửa => vậy phải có 1 cái table,  cột 1 cột là devID
    //1 cột là repaỉrContent, 1 cot la trang thai
    //lúc search sẽ hiện ra bảng luôn, rồi sao đó có thể update gì đó thì tùy
    //không đổi Dep thì Dep giữ nguyên => vậy thì có cho null, còn content repair thì sữa zo

    
    public Vector toVectorForStaffView() {
        Vector v = new Vector();
        v.add(devID);
        v.add(requirementContent);
        v.add(repairContent);
        v.add(empID);
        return v;
    }
    
    public MaintainanceDTO(int empID, int devID, String requirementContent) {
        this.empID = empID;
        this.devID = devID;
        this.requirementContent = requirementContent;
    }
//    
    public MaintainanceDTO(int empID, int devID, String requirementContent, String repairContent, String result) {
        this.empID = empID;
        this.devID = devID;
        this.requirementContent = requirementContent;
        this.repairContent = repairContent;
        this.result = result;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
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

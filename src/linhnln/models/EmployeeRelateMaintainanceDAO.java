/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import linhnln.db.MyConnection;
import linhnln.dtos.EmployeeRelateMaintainanceDTO;

/**
 *
 * @author Liam Nguyen
 */
public class EmployeeRelateMaintainanceDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public List<EmployeeRelateMaintainanceDTO> getHistoryAllDevice() throws Exception {
        List<EmployeeRelateMaintainanceDTO> dto = null;
        try {
            String sql = "Select tblEmployee.EmpName, tblDevice.DevName, tblMaintainance.RequirementTime, "
                    + "tblMaintainance.RequirementContent, tblMaintainance.RepairEndDate, "
                    + "tblMaintainance.RepairContent, tblMaintainance.Result, tblMaintainance.StaffName "
                    + "From tblEmployee "
                    + "Inner Join tblMaintainance "
                    + "On tblEmployee.EmpID = tblMaintainance.EmpID "
                    + "Inner Join tblDevice "
                    + "On tblDevice.DevID = tblMaintainance.DevID ";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dto = new ArrayList<>();
            while (rs.next()) {
                String empName = rs.getString("EmpName");
                String devName = rs.getString("DevName");
                Timestamp requirementTime = rs.getTimestamp("RequirementTime");
                String requirementContent = rs.getString("RequirementContent");
                Timestamp repairEndDate = rs.getTimestamp("RepairEndDate");
                String repairContent = rs.getString("RepairContent");
                String result = rs.getString("Result");
                String staffName = rs.getString("StaffName");
                dto.add(new EmployeeRelateMaintainanceDTO(empName, devName,requirementContent, repairContent, result, staffName, requirementTime, repairEndDate));
            }
        } finally {
            closeConnection();
        }
        
        return dto;
    }
    
    public List<EmployeeRelateMaintainanceDTO> getAllListDeviceForHistoryTabByResultAndYear(String resultFromView, int yearStart, int yearEnd) throws Exception {
        List<EmployeeRelateMaintainanceDTO> dtoList = null;
        try {
            String sql = "Select tblEmployee.EmpName, tblDevice.DevName, tblMaintainance.RequirementTime, " +
                        "tblMaintainance.RequirementContent, tblMaintainance.RepairEndDate, " +
                        "tblMaintainance.RepairContent, tblMaintainance.Result, tblMaintainance.StaffName " +
                        "From tblEmployee " +
                        "Inner Join tblMaintainance " +
                        "On tblEmployee.EmpID = tblMaintainance.EmpID " +
                        "Inner Join tblDevice " +
                        "On tblDevice.DevID = tblMaintainance.DevID " +
                        "WHERE tblMaintainance.Result = ? AND YEAR(tblMaintainance.RepairEndDate) BETWEEN ? AND ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, resultFromView);
            preSmt.setInt(2, yearStart);
            preSmt.setInt(3, yearEnd);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                String empName = rs.getString("EmpName");
                String devName = rs.getString("DevName");
                Timestamp requirementTime = rs.getTimestamp("RequirementTime");
                String requirementContent = rs.getString("RequirementContent");
                Timestamp repairEndDate = rs.getTimestamp("RepairEndDate");
                String repairContent = rs.getString("RepairContent");
                String result = rs.getString("Result");
                String staffName = rs.getString("StaffName");
                dtoList.add(new EmployeeRelateMaintainanceDTO(empName, devName, requirementContent, repairContent, result, staffName, requirementTime, repairEndDate));
            }
                    
        } finally {
            closeConnection();
        }
        return dtoList;
    }
}

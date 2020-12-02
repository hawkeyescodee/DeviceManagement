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
import linhnln.dtos.DeviceDepartmentRelateMaintainanceDTO;

/**
 *
 * @author Liam Nguyen
 */
public class AutoCheckRequiredDeviceDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public List<DeviceDepartmentRelateMaintainanceDTO> autoGenerateNumberOfDevice() throws Exception {
        List<DeviceDepartmentRelateMaintainanceDTO> dtos = null;
        DeviceDepartmentRelateMaintainanceDTO dto = null;
        int devID, repID;
        String devName = null;
        String depName = null;
        String requirementContent = null;
        String repairContent = null;
        String result = null;
        String staffName = null;
        Timestamp repairStartDate = null;
        Timestamp repairEndDate = null;
        try {
            String sql =  "Select tblMaintainance.RepID, tblDepartment.DepName, tblMaintainance.DevID, "
                        + "tblDevice.DevName, tblMaintainance.RequirementContent, tblMaintainance.RepairContent, tblMaintainance.RepairStartDate, "
                        + "tblMaintainance.RepairEndDate, tblMaintainance.Result, tblMaintainance.StaffName" +
                        " From tblDepartment" +
                        " Inner Join tblDevice" +
                        " On tblDepartment.DepID = tblDevice.DepID" +
                        " Inner Join tblMaintainance" +
                        " On tblDevice.DevID = tblMaintainance.DevID" + 
                        " WHERE dbo.tblMaintainance.Result = 'Required' AND DATEDIFF(DAY, dbo.tblMaintainance.RequirementTime, GETDATE()) >= 2";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dtos = new ArrayList<>();
            while (rs.next()) {
                repID = rs.getInt("RepID");
                depName = rs.getString("DepName");
                devID = rs.getInt("DevID");
                devName = rs.getString("DevName");
                requirementContent = rs.getString("RequirementContent");
                repairContent = rs.getString("RepairContent");
                repairStartDate = rs.getTimestamp("RepairStartDate");
                repairEndDate = rs.getTimestamp("RepairEndDate");
                result = rs.getString("Result");
                staffName = rs.getString("StaffName");
                dto = new DeviceDepartmentRelateMaintainanceDTO(devID, repID, devName, requirementContent, repairContent, result, depName, repairStartDate, repairEndDate, staffName);
                dtos.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtos;
    }
}

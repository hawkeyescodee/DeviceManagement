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
public class DeviceDepartmentRelateMaintainanceDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    //select theo bang trong view da thiet ke (cho Staffview)
    public List<DeviceDepartmentRelateMaintainanceDTO> showAllDeviceManaging() throws Exception {
        List<DeviceDepartmentRelateMaintainanceDTO> listOfAllDeviceMaintaining = null;
        int devID, repID;
        String devName = null;
        String depName = null;
        String requirementContent = null;
        String repairContent = null;
        String result = null;
        String staffName = null;
        Timestamp repairStartDate = null;
        Timestamp repairEndDate = null;
        
        DeviceDepartmentRelateMaintainanceDTO dto = null;
        try {
            String sql = "Select tblMaintainance.RepID, tblDepartment.DepName, tblMaintainance.DevID, "
                        + "tblDevice.DevName, tblMaintainance.RequirementContent, tblMaintainance.RepairContent, tblMaintainance.RepairStartDate, "
                        + "tblMaintainance.RepairEndDate, tblMaintainance.Result, tblMaintainance.StaffName" +
                        " From tblDepartment" +
                        " Inner Join tblDevice" +
                        " On tblDepartment.DepID = tblDevice.DepID" +
                        " Inner Join tblMaintainance" +
                        " On tblDevice.DevID = tblMaintainance.DevID";
                    
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            listOfAllDeviceMaintaining = new ArrayList<>();
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
                listOfAllDeviceMaintaining.add(dto);
            }
            //một con cừu xòe ra hai cái canhas à 
                   
        } finally {
            closeConnection();
        }
        
        return listOfAllDeviceMaintaining;
    }
    
//        //select theo bang trong view da thiet ke (cho Admin phần History)
//    public List<DeviceRelateMaintainanceDTO> showAllDeviceManagingForAdmin() throws Exception {
//        List<DeviceRelateMaintainanceDTO> listOfAllDeviceMaintaining = null;
//        int devID, repID;
//        String devName = null;
//        String depName = null;
//        String requirementContent = null;
//        String repairContent = null;
//        String result = null;
//        String staffName = null;
//        Timestamp repairStartDate = null;
//        Timestamp repairEndDate = null;
//        
//        DeviceDepartmentRelateMaintainanceDTO dto = null;
//        try {
//            String sql = "Select tblMaintainance.DevID, "
//                        + "tblDevice.DevName, tblMaintainance.RequirementContent, tblMaintainance.RepairContent, tblMaintainance.RepairStartDate, "
//                        + "tblMaintainance.RepairEndDate, tblMaintainance.Result, tblMaintainance.StaffName" +
//                        " From tblDepartment" +
//                        " INNER JOIN tblDevice" +
//                        " On tblDepartment.DepID = tblDevice.DepID" +
//                        " INNER JOIN tblMaintainance" +
//                        " On tblDevice.DevID = tblMaintainance.DevID";
//                    
//            conn = MyConnection.getMyConnection();
//            preSmt = conn.prepareStatement(sql);
//            rs = preSmt.executeQuery();
//            listOfAllDeviceMaintaining = new ArrayList<>();
//            while (rs.next()) {
//                repID = rs.getInt("RepID");
//                depName = rs.getString("DepName");
//                devID = rs.getInt("DevID");
//                devName = rs.getString("DevName");
//                requirementContent = rs.getString("RequirementContent");
//                repairContent = rs.getString("RepairContent");
//                repairStartDate = rs.getTimestamp("RepairStartDate");
//                repairEndDate = rs.getTimestamp("RepairEndDate");
//                result = rs.getString("Result");
//                staffName = rs.getString("StaffName");
//            dto = new DeviceDepartmentRelateMaintainanceDTO(devID, repID, devName, requirementContent, repairContent, result, depName, repairStartDate, repairEndDate, staffName);
//                listOfAllDeviceMaintaining.add(dto);
//            }
//                   
//        } finally {
//            closeConnection();
//        }
//        
//        return listOfAllDeviceMaintaining;
//    }
    
    //find dto de hien qua ben textfield
    public DeviceDepartmentRelateMaintainanceDTO findByPrimaryKey(int repID) throws Exception {
        DeviceDepartmentRelateMaintainanceDTO dto = null;
        try{ //tblMaintainance.RepID,
            String sql = "Select tblDepartment.DepID, tblMaintainance.DevID, "
            + "tblMaintainance.RepairContent, "
            + "tblMaintainance.Result, "
            + "tblMaintainance.StaffName" +
            " From tblDepartment" +
            " Inner Join tblDevice" +
            " On tblDepartment.DepID = tblDevice.DepID" +
            " Inner Join tblMaintainance" +
            " On tblDevice.DevID = tblMaintainance.DevID" +
            " Where tblMaintainance.RepID = ?";
            
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, repID);
            rs = preSmt.executeQuery();
            
            if (rs.next()) {
                int depID = rs.getInt("DepID");
                int devID = rs.getInt("DevID");
                String repairContent = rs.getString("RepairContent");
                String result = rs.getString("Result");
                String staffName = rs.getString("StaffName");
                dto = new DeviceDepartmentRelateMaintainanceDTO(depID, devID, repairContent, result, staffName);
            }
            
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    //tim lai dto sau khi cap nhat de set lai table
//    public DeviceDepartmentRelateMaintainanceDTO findByPrimaryKeyToUpdateTableModel(int repID) throws Exception {
//        DeviceDepartmentRelateMaintainanceDTO dto = null;
//        try{ //tblMaintainance.RepID,
//            String sql = "Select tblDepartment.DepName, tblMaintainance.RepairContent,  "
//            + "tblMaintainance.RepairStartDate, tblMaintainance.RepairEndDate,  "
//            + "tblMaintainance.Result" +
//            " From tblDepartment" +
//            " INNER JOIN tblDevice" +
//            " On tblDepartment.DepID = tblDevice.DepID" +
//            " INNER JOIN tblMaintainance" +
//            " On tblDevice.DevID = tblMaintainance.DevID" +
//            " Where tblMaintainance.RepID = ?";
//            
//            conn = MyConnection.getMyConnection();
//            preSmt = conn.prepareStatement(sql);
//            preSmt.setInt(1, repID);
//            rs = preSmt.executeQuery();
//            
//            if (rs.next()) {
//                String depName = rs.getString("depName");
//                String repairContent = rs.getString("RepairContent");
//                Timestamp repairStartDate = rs.getTimestamp("RepairStartDate");
//                Timestamp repairEndDate = rs.getTimestamp("RepairEndDate");
//                String result = rs.getString("Result");
//                
//                dto = new DeviceDepartmentRelateMaintainanceDTO(repairContent, result, depName, repairStartDate, repairEndDate);
//            }
//            
//        } finally {
//            closeConnection();
//        }
//        return dto;
//    }
    
    //updateDepID rieng tu bang Device
     public boolean updateDepID(DeviceDepartmentRelateMaintainanceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblDevice "
                    + "Set DepID = ? "
                    + "From tblDevice "
                    + "Inner Join tblMaintainance "
                    + "On tblMaintainance.DevID = tblDevice.DevID "
                    + "Inner Join dbo.tblDepartment "
                    + "On tblDepartment.DepID = tblDevice.DepID "
                    + "WHere RepID = ?";
            
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, dto.getDepID());
            preSmt.setInt(2, dto.getRepID());
            
            check = preSmt.executeUpdate() > 0;
            
        } finally {
            closeConnection();
        }
        
        return check;
        
    }
    
    //Update phan con lai trong bang Maintainance
    public boolean updateDateRepairContentResult(DeviceDepartmentRelateMaintainanceDTO dto) throws Exception {
        //RepID
        boolean check = false;
        
        try {
            String sql = "Update tblMaintainance "
                    + "Set RepairStartDate = ?, "
                    + "    RepairEndDate = ?, "
                    + "    RepairContent = ?, "
                    + "    Result = ?, "
                    + "    StaffName = ? "
                    + "From tblMaintainance "
                    + "Inner Join tblDevice "
                    + "On tblDevice.DevID = tblMaintainance.DevID "
                    + "Inner Join dbo.tblDepartment "
                    + "On tblDepartment.DepID = tblDevice.DepID "
                    + "WHERE RepID = ? ";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setTimestamp(1, dto.getRepairStartDate());
            preSmt.setTimestamp(2, dto.getRepairEndDate());
            preSmt.setString(3, dto.getRepairContent());
            preSmt.setString(4, dto.getResult());
            preSmt.setString(5, dto.getStaffName());
            preSmt.setInt(6, dto.getRepID());
            
            check = preSmt.executeUpdate() > 0;
            
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<DeviceDepartmentRelateMaintainanceDTO> findByPrimaryKeyToViewDevSearchedOnTbl(int devID) throws Exception {
        DeviceDepartmentRelateMaintainanceDTO dto = null;
        List<DeviceDepartmentRelateMaintainanceDTO> dtoList = null;
        try{ //tblMaintainance.RepID,
            String sql = "Select tblMaintainance.RepID, tblDepartment.DepName, "
                    + "tblDevice.DevID ,tblDevice.DevName, tblMaintainance.RequirementContent, tblMaintainance.RepairContent,  "
            + "tblMaintainance.RepairStartDate, tblMaintainance.RepairEndDate,  "
            + "tblMaintainance.Result, tblMaintainance.StaffName" +
            " From tblDepartment" +
            " Inner Join tblDevice" +
            " On tblDepartment.DepID = tblDevice.DepID" +
            " Inner Join tblMaintainance" +
            " On tblDevice.DevID = tblMaintainance.DevID" +
            " Where tblMaintainance.DevID = ?";
            
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, devID);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                int repID = rs.getInt("RepID");
                String depName = rs.getString("depName");
                //devID da co tu txtfield
                String requirementContent = rs.getString("RequirementContent");
                String repairContent = rs.getString("RepairContent");
                Timestamp repairStartDate = rs.getTimestamp("RepairStartDate");
                Timestamp repairEndDate = rs.getTimestamp("RepairEndDate");
                String result = rs.getString("Result");
                String staffName = rs.getString("StaffName");
                
                dto = new  DeviceDepartmentRelateMaintainanceDTO(devID, repID, depName, requirementContent, repairContent, result, depName, repairStartDate, repairEndDate, staffName);
                dtoList.add(dto);
            }
            
        } finally {
            closeConnection();
        }
        return dtoList;
    }
    
}

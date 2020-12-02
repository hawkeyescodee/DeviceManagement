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
import linhnln.dtos.DeviceRelateMaintainanceDTO;
/**
 *
 * @author Liam Nguyen
 */
public class DeviceRelateMaintainanceDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public List<DeviceRelateMaintainanceDTO> getAllListDeviceForStatisticTabByNumberOfRepairingInAsc() throws Exception {
        List<DeviceRelateMaintainanceDTO> dtoList = null;
        try {
            String sql = "SELECT tblDevice.DevID, tblDevice.Description, tblDevice.DevName, tblDevice.BuyingDate, tblDevice.Status, COUNT(tblMaintainance.RepID) " +
                            "FROM tblDevice " +
                            "INNER JOIN tblMaintainance " +
                            "ON tblDevice.DevID = tblMaintainance.DevID " +
                            "GROUP BY tblDevice.DevID, tblDevice.Description, tblDevice.DevName, tblDevice.BuyingDate, tblDevice.Status " +
                            "ORDER BY COUNT(tblMaintainance.RepID) ASC";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                int devID = rs.getInt("DevID");
                String description = rs.getString("Description");
                String devName = rs.getString("DevName");
                Timestamp buyingDate = rs.getTimestamp("BuyingDate");
                String status = rs.getString("Status");
                int noOfRepairing = rs.getInt(6);
                DeviceRelateMaintainanceDTO dto = new DeviceRelateMaintainanceDTO(devID, noOfRepairing, description, devName, status, buyingDate);
                dtoList.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtoList;
    }
    
        public List<DeviceRelateMaintainanceDTO> getAllListDeviceForStatisticTabByNumberOfRepairingInDesc() throws Exception {
        List<DeviceRelateMaintainanceDTO> dtoList = null;
        try {
            String sql = "SELECT tblDevice.DevID, tblDevice.Description, tblDevice.DevName, tblDevice.BuyingDate, tblDevice.Status, COUNT(tblMaintainance.RepID) " +
                            "FROM tblDevice "
                            + "INNER JOIN tblMaintainance " +
                            "ON tblDevice.DevID = tblMaintainance.DevID " +
                            "GROUP BY tblDevice.DevID, tblDevice.Description, tblDevice.DevName, tblDevice.BuyingDate, tblDevice.Status " +
                            "ORDER BY COUNT(tblMaintainance.RepID) Desc";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                int devID = rs.getInt("DevID");
                String description = rs.getString("Description");
                String devName = rs.getString("DevName");
                Timestamp buyingDate = rs.getTimestamp("BuyingDate");
                String status = rs.getString("Status");
                int noOfRepairing = rs.getInt(6);
                DeviceRelateMaintainanceDTO dto = new DeviceRelateMaintainanceDTO(devID, noOfRepairing, description, devName, status, buyingDate);
                dtoList.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtoList;
    }
}

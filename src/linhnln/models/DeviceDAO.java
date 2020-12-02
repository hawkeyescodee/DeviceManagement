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
import linhnln.dtos.DeviceDTO;

/**
 *
 * @author Liam Nguyen
 */
public class DeviceDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public DeviceDTO findByPrimaryKey(int key) throws Exception {
        DeviceDTO dto = null;
        try {
            String sql = "Select DevID, Description, DevName From tblDevice Where DevID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, key);
            rs = preSmt.executeQuery();
            if (rs.next()) {
                int devID = Integer.parseInt(rs.getString("DevID"));
                String description = rs.getString("Description");
                String devName = rs.getString("DevName");
                dto = new DeviceDTO(devID, description, devName);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List<DeviceDTO> getAllListOfDevice() throws Exception {
        List<DeviceDTO> dto = null;
        int devID = 0;
        String devName = null;
        String description = null;
        try {
            String sql = "Select DevID, Description, DevName From tblDevice";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dto = new ArrayList<>();
            while (rs.next()) {
                devID = rs.getInt("DevID");
                description = rs.getString("Description");
                devName = rs.getString("DevName");
                dto.add(new DeviceDTO(devID, description, devName));
                        
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public DeviceDTO findByPrimaryKeyForAdmin(int key) throws Exception {
        DeviceDTO dto = null;
        try {
            String sql = "Select DevID, Image, Description, DevName, BuyingDate, CateID, DepID, Status From tblDevice Where DevID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, key);
            rs = preSmt.executeQuery();
            if (rs.next()) {
                int devID = Integer.parseInt(rs.getString("DevID"));
                String image = rs.getString("Image");
                String description = rs.getString("Description");
                String devName = rs.getString("DevName");
                Timestamp buyingDate = rs.getTimestamp("BuyingDate");
                int cateID = rs.getInt("CateID");
                int depID = rs.getInt("DepID");
                String status = rs.getString("Status");
                dto = new DeviceDTO(devID, depID, image, description, devName, cateID, buyingDate, status);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean updateDeviceForAdmin(DeviceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblDevice Set Image = ?, Description = ?, DevName = ?, BuyingDate = ?, "
                    + "CateID = ?, DepID = ?, Status = ?  Where DevID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, dto.getImg());
            preSmt.setString(2, dto.getDescription());
            preSmt.setString(3, dto.getDevName());
            preSmt.setTimestamp(4, dto.getBuyingDate());
            preSmt.setInt(5, dto.getCateID());
            preSmt.setInt(6, dto.getDepID());
            preSmt.setString(7, dto.getStatus());
            preSmt.setInt(8, dto.getDevID());
            check = preSmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    //update them cot chu khong duoc bo
    //vấn đề là xóa trong DB sẽ bị sai, vẫn còn trong db nhưng được đánh dấu là "Deleted"
    public boolean delete(int devID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblDevice Set Status = ? Where devID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, "Disabled");
            preSmt.setInt(2, devID);
            check = preSmt.executeUpdate() > 0;
        } finally {
        }
        return check;
    }
   
    
    public List<DeviceDTO> getAllListDevice() throws Exception {
        List<DeviceDTO> listOfDeviceForAdmin = null;
        int devID, depID, cateID;
        String image = null;
        String description = null;
        String devName = null;
        Timestamp buyingDate = null;
        DeviceDTO dto = null;
        String status = null;
        try {
            String sql = "Select DevID, Image, Description, DevName, BuyingDate, CateID, DepID, Status "
                    + "From tblDevice";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            listOfDeviceForAdmin = new ArrayList<>();
            while (rs.next()) {
                devID = rs.getInt("DevID");
                image = rs.getString("Image");
                description = rs.getString("Description");
                devName = rs.getString("DevName");
                buyingDate = rs.getTimestamp("BuyingDate");
                cateID = rs.getInt("CateID");
                depID = rs.getInt("DepID");
                status = rs.getString("status");
                dto = new DeviceDTO(devID, depID, image, description, devName, cateID, buyingDate, status);
                listOfDeviceForAdmin.add(dto);
            }
        } finally {
            closeConnection();
            
        }
        return listOfDeviceForAdmin;
        
    }
    
    public List<DeviceDTO> getAllListDeviceForStatisticTab() throws Exception {
        List<DeviceDTO> dtoList = null;
        int devID = 0;
        String description = null;
        String devName = null;
        Timestamp buyingDate = null;
        DeviceDTO dto = null;
        String status = null;
        try {
            String sql = "Select DevID, Description, DevName, BuyingDate, Status "
                    + "From tblDevice";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                devID = rs.getInt("DevID");
                description = rs.getString("Description");
                devName = rs.getString("DevName");
                buyingDate = rs.getTimestamp("BuyingDate");
                status = rs.getString("Status");
                dto = new DeviceDTO(devID, description, devName, status, buyingDate);
                dtoList.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtoList;
    }
    
    public List<DeviceDTO> getDevicesWithTimeRangeAndStatus(String statusSelected, int yearStart, int yearEnd) throws Exception{
        List<DeviceDTO> dtoList = null;
        int devID = 0;
        String description = null;
        String devName = null;
        Timestamp buyingDate = null;
        DeviceDTO dto = null;
        String status = null;
        try {
            String sql = "Select DevID, Description, DevName, BuyingDate, Status "
                    + "From tblDevice "
                    + "Where Status = ? And YEAR(BuyingDate) Between ? And ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, statusSelected);
            preSmt.setInt(2, yearStart);
            preSmt.setInt(3, yearEnd);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                devID = rs.getInt("DevID");
                description = rs.getString("Description");
                devName = rs.getString("DevName");
                buyingDate = rs.getTimestamp("BuyingDate");
                status = rs.getString("Status");
                dto = new DeviceDTO(devID, description, devName, status, buyingDate);
                dtoList.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtoList;
    }
    
    public boolean insertDev(DeviceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into tblDevice (DevID, Image, Description, DevName, BuyingDate, CateID, DepID, Status) Values(?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, dto.getDevID());
            preSmt.setString(2, dto.getImg());
            preSmt.setString(3, dto.getDescription());
            preSmt.setString(4, dto.getDevName());
            preSmt.setTimestamp(5, dto.getBuyingDate());
            preSmt.setInt(6, dto.getCateID());
            preSmt.setInt(7, dto.getDepID());
            preSmt.setString(8, dto.getStatus());
            check = preSmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}

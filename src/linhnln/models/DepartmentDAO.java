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
import java.util.ArrayList;
import java.util.List;
import linhnln.db.MyConnection;
import linhnln.dtos.DepartmentDTO;

/**
 *
 * @author Liam Nguyen
 */
public class DepartmentDAO implements Serializable {
    private Connection conn; 
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public List<DepartmentDTO> getListAllDep() throws Exception {
        List<DepartmentDTO> dtoList = null;
        int depID = 0;
        String depName = null;
        String status = null;
        DepartmentDTO dto = null;
        try {
            String sql = "Select DepID, DepName, Status From tblDepartment";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            dtoList = new ArrayList<>();
            while (rs.next()) {
                depID = rs.getInt("DepID");
                depName = rs.getString("DepName");
                status = rs.getString("Status");
                dto = new DepartmentDTO(depID, depName, status);
                dtoList.add(dto);
            }
        } finally {
            closeConnection();
        }
        return dtoList;
    }
    
    
    //check lai coi search ra null thi sao
    public DepartmentDTO findDepartmentByPrimaryKey(int depID) throws Exception {
        DepartmentDTO dto = null;
        try {
            String sql = "Select DepID, DepName, Status From tblDepartment Where DepID = ? ";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, depID);
            rs = preSmt.executeQuery(); //ket qua tra ve
            if (rs.next()) {
                String depName = rs.getString("DepName");
                String status = rs.getString("Status");
                dto = new DepartmentDTO(depID, depName, status);
            } 
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insertNewDep(DepartmentDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblDepartment (DepID, DepName, Status) Values(?,?,?)";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, dto.getDepID());
            preSmt.setString(2, dto.getDepName());
            preSmt.setString(3, dto.getStatus());
            check = preSmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean deleteDep(int depID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblDepartment Set Status = ? Where DepID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, "Disabled");
            preSmt.setInt(2, depID);
            check = preSmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateDep(DepartmentDTO depDTO) throws Exception {
        boolean check = false; 
        try {
            String sql = "Update tblDepartment Set DepName = ?, Status = ?"
                    + " Where DepID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, depDTO.getDepName());
            preSmt.setString(2, depDTO.getStatus());
            preSmt.setInt(3, depDTO.getDepID());
            check = preSmt.executeUpdate() > 0;
                   
        } finally {
            closeConnection();
        }
                
        return check;
    }
    
    
}

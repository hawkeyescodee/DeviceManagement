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
import linhnln.dtos.EmployeeDTO;

/**
 *
 * @author Liam Nguyen
 */
public class EmployeeDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public List<EmployeeDTO> showAllEmployee() throws Exception {
        List<EmployeeDTO> listEmp = null;
        int empID, depID;
        String empName, sex;
        Timestamp dob = null;
        EmployeeDTO dto = null;
        try {
            String sql = "Select EmpID, EmpName, Sex, DOB, DepID "
                        + "From tblEmployee";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            rs = preSmt.executeQuery();
            listEmp = new ArrayList<>();
            while (rs.next()) {
                empID = rs.getInt("EmpID");
                empName = rs.getString("EmpName");
                sex = rs.getString("Sex");
                dob = rs.getTimestamp("DOB");
                depID = rs.getInt("DepID");
                dto = new EmployeeDTO(empID, depID, empName, sex, dob);
                listEmp.add(dto);
            }
        } finally {
            closeConnection();
        }
        return listEmp;
    }
    
    public boolean insertEmp(EmployeeDTO empDTO) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblEmployee(EmpID, EmpName, Sex, DOB, DepID) values(?,?,?,?,?)";
            
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            
            preSmt.setInt(1, empDTO.getEmpID());
            preSmt.setString(2, empDTO.getEmpName());
            preSmt.setString(3, empDTO.getSex());
            preSmt.setTimestamp(4, empDTO.getDob());
            preSmt.setInt(5, empDTO.getDepID());
            
            check = preSmt.executeUpdate() > 0;
            
        } finally {
            closeConnection();
            
        }
        return check;
    }
    
    public EmployeeDTO findByPrimaryKey(int empIDToFind) throws Exception {
        EmployeeDTO dto = null;
        try {
            String sql = "Select EmpID, EmpName, Sex, DOB, DepID From tblEmployee "
                    + "Where EmpID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, empIDToFind);
            rs = preSmt.executeQuery(); 
            if (rs.next()) {
                int empID = rs.getInt("EmpID");
                String empName = rs.getString("EmpName");
                String sex = rs.getString("Sex");
                Timestamp dob = rs.getTimestamp("DOB");
                int depID = rs.getInt("DepID");
                dto = new EmployeeDTO(empID, depID, empName, sex, dob);
                
            }
        } finally {
            closeConnection();
        }         
        return dto;        
    }
    
    public boolean updateEmployee(EmployeeDTO dto) throws Exception {
        boolean check = true;
        try {
            String sql = "Update tblEmployee Set EmpName = ?, Sex = ?, DOB = ?, DepID = ? "
                    + "Where EmpID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setString(1, dto.getEmpName());
            preSmt.setString(2, dto.getSex());
            preSmt.setTimestamp(3, dto.getDob());
            preSmt.setInt(4, dto.getDepID());
            preSmt.setInt(5, dto.getEmpID());
            
            check = preSmt.executeUpdate() > 0;
                    
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(int empID) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From tblEmployee Where empID = ?";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, empID);
            check = preSmt.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    
}

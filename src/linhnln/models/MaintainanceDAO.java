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
import linhnln.db.MyConnection;
import linhnln.dtos.MaintainanceDTO;

/**
 *
 * @author Liam Nguyen
 */
public class MaintainanceDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preSmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preSmt != null) preSmt.close();
        if (conn != null) conn.close();
    }
    
    public boolean insert(MaintainanceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblMaintainance(EmpID, DevID, RequirementContent"
                    + ", RequirementTime, Result) values(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preSmt = conn.prepareStatement(sql);
            preSmt.setInt(1, dto.getEmpID());
            preSmt.setInt(2, dto.getDevID());
            preSmt.setString(3, dto.getRequirementContent());
            preSmt.setTimestamp(4, dto.getRequirementTime());
            preSmt.setString(5, dto.getResult());
            check = preSmt.executeUpdate() > 0;
            
        } finally {
            closeConnection();
        }
        return check;
    }
     
}

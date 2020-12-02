/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Liam Nguyen
 */
public class DepartmentDTO implements Serializable {
    private int depID; 
    private String depName, status;

    public DepartmentDTO(int depID, String depName, String status) {
        this.depID = depID;
        this.depName = depName;
        this.status = status;
    }
    
    public Vector toVector() {
        Vector v = new Vector<>();
        v.add(depID);
        v.add(depName);
        v.add(status);
        return v;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

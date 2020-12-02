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
public class EmployeeDTO implements Serializable {
    private int empID, depID;
    private String empName, sex;
    private Timestamp dob;

    public EmployeeDTO(int empID, int depID, String empName, String sex, Timestamp dob) {
        this.empID = empID;
        this.depID = depID;
        this.empName = empName;
        this.sex = sex;
        this.dob = dob;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(empID);
        v.add(empName);
        v.add(sex);
        v.add(dob);
        v.add(depID);
        return v;
    }
    
    
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }
    
    
}

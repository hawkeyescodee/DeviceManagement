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
public class DeviceRelateMaintainanceDTO implements Serializable {
    int devID, noOfRepairing;
    String description, devName, status;
    Timestamp buyingDate;
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(devID);
        v.add(description);
        v.add(devName);
        v.add(buyingDate);
        v.add(status);
        v.add(noOfRepairing);
        return v;
    }

    public DeviceRelateMaintainanceDTO(int devID, int noOfRepairing, String description, String devName, String status, Timestamp buyingDate) {
        this.devID = devID;
        this.noOfRepairing = noOfRepairing;
        this.description = description;
        this.devName = devName;
        this.status = status;
        this.buyingDate = buyingDate;
    }

    public int getDevID() {
        return devID;
    }

    public void setDevID(int devID) {
        this.devID = devID;
    }

    public int getNoOfRepairing() {
        return noOfRepairing;
    }

    public void setNoOfRepairing(int noOfRepairing) {
        this.noOfRepairing = noOfRepairing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Timestamp buyingDate) {
        this.buyingDate = buyingDate;
    }
    
    
    
}

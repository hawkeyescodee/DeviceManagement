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
public class DeviceDTO implements Serializable {
    private int devID, depID, cateID;
    private String img, description, devName, status;
    private Timestamp buyingDate;

    public Vector toVector() {
        Vector v = new Vector();
        v.add(devID);
        v.add(description);
        v.add(devName);
        return v; 
    }
    
    public Vector toVectorForStatistic() {
        Vector v = new Vector();
        v.add(devID);
        v.add(description);
        v.add(devName);
        v.add(buyingDate);
        v.add(status);
        return v;
    }
    
    public Vector toVectorForAdmin() {
        Vector v = new Vector();
        v.add(devID);
        v.add(description);
        v.add(devName);
        v.add(buyingDate);
        v.add(cateID);
        v.add(depID);
        v.add(status);
        return v; 
    }
    

    public DeviceDTO(int devID, String description, String devName) {
        this.devID = devID;
        this.description = description;
        this.devName = devName;
    }

    public DeviceDTO(int devID, int depID, String img, String description, String devName, int cateID, Timestamp buyingDate, String status) {
        this.devID = devID;
        this.depID = depID;
        this.img = img;
        this.description = description;
        this.devName = devName;
        this.cateID = cateID;
        this.buyingDate = buyingDate;
        this.status = status;
    }

    public DeviceDTO(int devID, String description, String devName, String status, Timestamp buyingDate) {
        this.devID = devID;
        this.description = description;
        this.devName = devName;
        this.status = status;
        this.buyingDate = buyingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getDevID() {
        return devID;
    }

    public void setDevID(int devID) {
        this.devID = devID;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Timestamp getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Timestamp buyingDate) {
        this.buyingDate = buyingDate;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }


    
    
}

package com.exadel.axonexample.axonhouseapp.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HouseEntry {
    @Id
    @GeneratedValue
    private long id;

    private String houseId;
    private boolean isFundamentBuilt;
    private boolean isWallsBuilt;
    private boolean isWindowsBuilt;
    private boolean isRoofBuilt;

    public HouseEntry() {
    }

    public HouseEntry(String houseId) {
        this.houseId = houseId;
    }

    public HouseEntry(String houseId, boolean isFundamentBuilt, boolean isWallsBuilt, boolean isWindowsBuilt, boolean isRoofBuilt) {
        this.isFundamentBuilt = isFundamentBuilt;
        this.isWallsBuilt = isWallsBuilt;
        this.isWindowsBuilt = isWindowsBuilt;
        this.isRoofBuilt = isRoofBuilt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public boolean isFundamentBuilt() {
        return isFundamentBuilt;
    }

    public void setFundamentBuilt(boolean fundamentBuilt) {
        isFundamentBuilt = fundamentBuilt;
    }

    public boolean isWallsBuilt() {
        return isWallsBuilt;
    }

    public void setWallsBuilt(boolean wallsBuilt) {
        isWallsBuilt = wallsBuilt;
    }

    public boolean isWindowsBuilt() {
        return isWindowsBuilt;
    }

    public void setWindowsBuilt(boolean windowsBuilt) {
        isWindowsBuilt = windowsBuilt;
    }

    public boolean isRoofBuilt() {
        return isRoofBuilt;
    }

    public void setRoofBuilt(boolean roofBuilt) {
        isRoofBuilt = roofBuilt;
    }
}

package com.exadel.axonexample.axonhouseapp.domain.event;

public class WallsBuiltEvent {
    private String houseId;

    public WallsBuiltEvent() {
    }

    public WallsBuiltEvent(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}

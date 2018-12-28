package com.exadel.axonexample.axonhouseapp.domain.event;

public class RoofDoneEvent {
    private String houseId;

    public RoofDoneEvent() {
    }

    public RoofDoneEvent(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}

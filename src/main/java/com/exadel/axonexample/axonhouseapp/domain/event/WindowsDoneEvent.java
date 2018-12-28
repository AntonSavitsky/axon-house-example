package com.exadel.axonexample.axonhouseapp.domain.event;

public class WindowsDoneEvent {
    private String houseId;

    public WindowsDoneEvent() {
    }

    public WindowsDoneEvent(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}

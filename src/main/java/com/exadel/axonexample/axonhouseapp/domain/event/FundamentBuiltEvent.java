package com.exadel.axonexample.axonhouseapp.domain.event;

public class FundamentBuiltEvent {
    private String houseId;

    public FundamentBuiltEvent() {
    }

    public FundamentBuiltEvent(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}

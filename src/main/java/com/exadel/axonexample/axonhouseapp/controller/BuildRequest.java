package com.exadel.axonexample.axonhouseapp.controller;

public class BuildRequest {
    private String id;

    public BuildRequest() {
    }

    public BuildRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

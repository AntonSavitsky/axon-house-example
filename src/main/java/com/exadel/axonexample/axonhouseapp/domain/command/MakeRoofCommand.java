package com.exadel.axonexample.axonhouseapp.domain.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class MakeRoofCommand {
    @TargetAggregateIdentifier
    private String id;

    public MakeRoofCommand() {
    }

    public MakeRoofCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

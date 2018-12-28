package com.exadel.axonexample.axonhouseapp.domain.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BuildWallsCommand {
    @TargetAggregateIdentifier
    private String id;

    public BuildWallsCommand() {
    }

    public BuildWallsCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

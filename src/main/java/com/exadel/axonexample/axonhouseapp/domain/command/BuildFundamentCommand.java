package com.exadel.axonexample.axonhouseapp.domain.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BuildFundamentCommand {
    @TargetAggregateIdentifier
    private String id;

    public BuildFundamentCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

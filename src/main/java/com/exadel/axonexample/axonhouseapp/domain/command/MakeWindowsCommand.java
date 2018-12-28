package com.exadel.axonexample.axonhouseapp.domain.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class MakeWindowsCommand {
    @TargetAggregateIdentifier
    private String id;

    public MakeWindowsCommand() {
    }

    public MakeWindowsCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

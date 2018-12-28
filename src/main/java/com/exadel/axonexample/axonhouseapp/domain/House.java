package com.exadel.axonexample.axonhouseapp.domain;

import com.exadel.axonexample.axonhouseapp.domain.command.BuildFundamentCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.BuildWallsCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.MakeRoofCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.MakeWindowsCommand;
import com.exadel.axonexample.axonhouseapp.domain.event.FundamentBuiltEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.RoofDoneEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.WallsBuiltEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.WindowsDoneEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class House {
    @AggregateIdentifier
    private String id;

    private boolean isFundamentBuilt;
    private boolean isWallsBuilt;
    private boolean isWindowsBuilt;
    private boolean isRoofBuilt;

    public House() {
    }

    @CommandHandler
    public House(BuildFundamentCommand command) {
        apply(new FundamentBuiltEvent(command.getId()));
    }

    @CommandHandler
    void on(BuildWallsCommand command) {
        if (isFundamentBuilt && !isWallsBuilt) {
            apply(new WallsBuiltEvent(command.getId()));
        }
    }

    @CommandHandler
    void on(MakeWindowsCommand command) {
        if (isFundamentBuilt && isWallsBuilt && !isWindowsBuilt) {
            apply(new WindowsDoneEvent(command.getId()));
        }
    }

    @CommandHandler
    void on(MakeRoofCommand command) {
        if (isFundamentBuilt && isWallsBuilt && isWindowsBuilt && !isRoofBuilt) {
            apply(new RoofDoneEvent(command.getId()));
        }
    }

    @EventSourcingHandler
    public void on(FundamentBuiltEvent evt) {
        id = evt.getHouseId();
        isFundamentBuilt = true;
    }

    @EventSourcingHandler
    public void on(WallsBuiltEvent evt) {
        id = evt.getHouseId();
        isWallsBuilt = true;
    }

    @EventSourcingHandler
    public void on(WindowsDoneEvent evt) {
        id = evt.getHouseId();
        isWindowsBuilt = true;
    }

    @EventSourcingHandler
    public void on(RoofDoneEvent evt) {
        id = evt.getHouseId();
        isRoofBuilt = true;
    }
}

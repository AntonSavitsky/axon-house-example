package com.exadel.axonexample.axonhouseapp.query;

import com.exadel.axonexample.axonhouseapp.domain.event.FundamentBuiltEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.RoofDoneEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.WallsBuiltEvent;
import com.exadel.axonexample.axonhouseapp.domain.event.WindowsDoneEvent;
import com.exadel.axonexample.axonhouseapp.repository.HouseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author albert
 */
@Component
public class HouseEventHandler {

	private HouseRepository houseRepository;
	
	@Autowired
	public HouseEventHandler(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}
	
	@EventHandler
	void on(FundamentBuiltEvent event) {
		HouseEntry houseEntry = new HouseEntry(event.getHouseId());
		houseEntry.setFundamentBuilt(true);
		houseRepository.save(houseEntry);
	}

	@EventHandler
	void on(WallsBuiltEvent event) {
		HouseEntry houseEntry = houseRepository.findOneByHouseId(event.getHouseId());
		houseEntry.setWallsBuilt(true);
		houseRepository.save(houseEntry);
	}

	@EventHandler
	void on(WindowsDoneEvent event) {
		HouseEntry houseEntry = houseRepository.findOneByHouseId(event.getHouseId());
		houseEntry.setWindowsBuilt(true);
		houseRepository.save(houseEntry);
	}

	@EventHandler
	void on(RoofDoneEvent event) {
		HouseEntry houseEntry = houseRepository.findOneByHouseId(event.getHouseId());
		houseEntry.setRoofBuilt(true);
		houseRepository.save(houseEntry);
	}
}

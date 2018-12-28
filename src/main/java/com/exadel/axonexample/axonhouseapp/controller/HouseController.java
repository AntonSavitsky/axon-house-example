package com.exadel.axonexample.axonhouseapp.controller;

import com.exadel.axonexample.axonhouseapp.domain.command.BuildFundamentCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.BuildWallsCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.MakeRoofCommand;
import com.exadel.axonexample.axonhouseapp.domain.command.MakeWindowsCommand;
import com.exadel.axonexample.axonhouseapp.query.HouseEntry;
import com.exadel.axonexample.axonhouseapp.repository.HouseRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

	private final IdentifierFactory identifierFactory = IdentifierFactory.getInstance();

	private HouseRepository houseRepository;

	private CommandGateway commandGateway;

	@Autowired
	public HouseController(HouseRepository houseRepository, CommandGateway commandGateway) {
		this.houseRepository = houseRepository;
		this.commandGateway = commandGateway;
	}

	@RequestMapping(value = "/houses", method = RequestMethod.GET)
	public @ResponseBody
	List<HouseEntry> findAll() {
		return houseRepository.findAll();
	}

	@RequestMapping(value = "/house/fundament", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void buildFundament() {
		commandGateway.send(new BuildFundamentCommand(identifierFactory.generateIdentifier()));
	}

	@RequestMapping(value = "/house/{buildStep}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String buildStep(@PathVariable("buildStep") String buildStep, @RequestBody BuildRequest request) {
		switch (buildStep) {
			case "walls": {
				commandGateway.send(new BuildWallsCommand(request.getId()));
				break;
			}
			case "windows": {
				commandGateway.send(new MakeWindowsCommand(request.getId()));
				break;
			}
			case "roof": {
				commandGateway.send(new MakeRoofCommand(request.getId()));
				break;
			}
			default:
				return "No such build step";
		}
		return "Building in progress";
	}

}

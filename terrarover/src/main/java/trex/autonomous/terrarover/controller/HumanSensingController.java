package trex.autonomous.terrarover.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trex.autonomous.terrarover.model.HumanSensingModel;
import trex.autonomous.terrarover.service.HumanSensingService;

import java.util.List;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:46 pm
 * @package-name trex.autonomous.terrarover.controller
 * @project terrarover
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/human-sensing")
public class HumanSensingController {

	private final HumanSensingService service;

	@PostMapping ("/")
	public ResponseEntity < HumanSensingModel > handleAddHumanSensingData (
			@RequestBody HumanSensingModel humanSensingModel
			) {
		return ResponseEntity.ok(service.addHumanSensingData(humanSensingModel));
	}

	@GetMapping ("/")
	public ResponseEntity < List < HumanSensingModel > > handleGetAllHumanSensingData () {
		return ResponseEntity.ok(service.getAllHumanSensingData());
	}

}

package trex.autonomous.terrarover.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trex.autonomous.terrarover.model.GasSensorModel;
import trex.autonomous.terrarover.service.GasSensorService;

import java.util.List;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:32 pm
 * @package-name trex.autonomous.terrarover.controller
 * @project terrarover
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gas-sensor")
public class GasSensorController {

	private final GasSensorService service;

	@PostMapping ("/")
	public ResponseEntity < GasSensorModel > handleAddGasSensorData (
			@RequestBody GasSensorModel gasSensorModel
	) {
		return ResponseEntity.ok(service.addGasSensorData(gasSensorModel));
	}

	@GetMapping ("/")
	public ResponseEntity < List < GasSensorModel > > handleGetAllGasSensorData () {
		return ResponseEntity.ok(service.getAllGasSensorData());
	}

}

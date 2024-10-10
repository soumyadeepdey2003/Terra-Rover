package trex.autonomous.terrarover.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trex.autonomous.terrarover.model.SensorModel;
import trex.autonomous.terrarover.service.SensorService;

import java.util.List;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:18 pm
 * @package-name trex.autonomous.terrarover.controller
 * @project terrarover
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sensor")
public class SensorController {

	private final SensorService service;

	@PostMapping("/")
	public ResponseEntity < SensorModel > handleAddSensorData (
			@RequestBody SensorModel sensorModel
			) {
		return ResponseEntity.ok(service.addSensorData(sensorModel));
	}

	@GetMapping("/")
	public ResponseEntity < List < SensorModel > > handleGetAllSensorData () {
		return ResponseEntity.ok(service.getAllSensorData());
	}

}

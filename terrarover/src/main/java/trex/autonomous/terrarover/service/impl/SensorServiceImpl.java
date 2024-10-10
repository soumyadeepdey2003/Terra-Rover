package trex.autonomous.terrarover.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import trex.autonomous.terrarover.model.SensorModel;
import trex.autonomous.terrarover.repository.SensorRepository;
import trex.autonomous.terrarover.service.SensorService;

import java.util.List;

/**
 * @author cocat
 * @created 26-08-2024 - 09:19 pm
 * @package-name trex.autonomous.terrarover.service.impl
 * @project terrarover
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

	private final SensorRepository repository;

	private SensorModel previousModel = null;

	@Override
	public SensorModel addSensorData ( SensorModel sensorModel ) {
		try {
			if (!sensorModel.equals(previousModel)) {
				previousModel = sensorModel;
				SensorModel savedModel = repository.save(sensorModel);
				log.info("Sensor data added successfully: {}", savedModel);
				return savedModel;
			}
			log.info("Sensor data updated successfully: {}", previousModel);
			return previousModel;
		} catch ( Exception e ) {
			log.error("Error while adding sensor data: {}", e.getMessage());
			throw new RuntimeException("Error while adding sensor data");
		}
	}

	@Override
	public List< SensorModel > getAllSensorData () {
		try {
			List< SensorModel > sensorModels = repository.findAll();
			log.info("Sensor data fetched successfully: {}", sensorModels);
			return sensorModels;
		} catch ( Exception e ) {
			log.error("Error while fetching sensor data: {}", e.getMessage());
			throw new RuntimeException("Error while fetching sensor data");
		}
	}

}

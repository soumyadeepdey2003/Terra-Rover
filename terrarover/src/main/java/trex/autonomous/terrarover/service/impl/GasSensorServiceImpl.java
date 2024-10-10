package trex.autonomous.terrarover.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import trex.autonomous.terrarover.model.GasSensorModel;
import trex.autonomous.terrarover.repository.GasSensorRepository;
import trex.autonomous.terrarover.service.GasSensorService;

import java.util.List;

/**
 * @author cocat
 * @created 26-08-2024 - 09:31 pm
 * @package-name trex.autonomous.terrarover.service.impl
 * @project terrarover
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GasSensorServiceImpl implements GasSensorService {

	private final GasSensorRepository repository;

	private GasSensorModel previousModel = null;

	@Override
	public GasSensorModel addGasSensorData ( GasSensorModel gasSensorModel ) {
		try {
			if ( !gasSensorModel.equals(previousModel) ) {
				previousModel = gasSensorModel;
				GasSensorModel savedModel = repository.save(gasSensorModel);
				log.info("Gas sensor data added successfully: {}", savedModel);
				return savedModel;
			}
			log.info("Gas sensor data updated successfully: {}", previousModel);
			return previousModel;
		} catch ( Exception e ) {
			log.error("Error while adding gas sensor data: {}", e.getMessage());
			throw new RuntimeException("Error while adding gas sensor data");
		}
	}

	@Override
	public List< GasSensorModel > getAllGasSensorData () {
		try {
			List < GasSensorModel > gasSensorModels = repository.findAll();
			log.info("Gas sensor data fetched successfully: {}", gasSensorModels);
			return gasSensorModels;
		} catch ( Exception e ) {
			log.error("Error while fetching gas sensor data: {}", e.getMessage());
			throw new RuntimeException("Error while fetching gas sensor data");
		}
	}

}

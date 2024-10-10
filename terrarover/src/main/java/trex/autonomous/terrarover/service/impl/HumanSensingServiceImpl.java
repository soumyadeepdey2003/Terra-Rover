package trex.autonomous.terrarover.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import trex.autonomous.terrarover.model.HumanSensingModel;
import trex.autonomous.terrarover.repository.HumanSensingRepository;
import trex.autonomous.terrarover.service.HumanSensingService;

import java.util.List;

/**
 * @author cocat
 * @created 26-08-2024 - 09:45 pm
 * @package-name trex.autonomous.terrarover.service.impl
 * @project terrarover
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class HumanSensingServiceImpl implements HumanSensingService {

	private final HumanSensingRepository repository;

	private HumanSensingModel previousModel = null;

	@Override
	public HumanSensingModel addHumanSensingData ( HumanSensingModel humanSensingModel ) {
		try {
			if ( !humanSensingModel.equals(previousModel) ) {
				previousModel = humanSensingModel;
				HumanSensingModel savedModel = repository.save(humanSensingModel);
				log.info("Human sensing data added successfully: {}", savedModel);
				return savedModel;
			}
			log.info("Human sensing data updated successfully: {}", previousModel);
			return previousModel;
		} catch ( Exception e ) {
			log.error("Error while adding human sensing data: {}", e.getMessage());
			throw new RuntimeException("Error while adding human sensing data");
		}
	}

	@Override
	public List< HumanSensingModel > getAllHumanSensingData () {
		try {
			List < HumanSensingModel > humanSensingModels = repository.findAll();
			log.info("Human sensing data fetched successfully: {}", humanSensingModels);
			return humanSensingModels;
		} catch ( Exception e ) {
			log.error("Error while fetching human sensing data: {}", e.getMessage());
			throw new RuntimeException("Error while fetching human sensing data");
		}
	}

}

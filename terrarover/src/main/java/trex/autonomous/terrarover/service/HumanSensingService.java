package trex.autonomous.terrarover.service;

import trex.autonomous.terrarover.model.HumanSensingModel;

import java.util.List;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:45 pm
 * @package-name trex.autonomous.terrarover.service
 * @project terrarover
 */

public interface HumanSensingService {
	public HumanSensingModel addHumanSensingData ( HumanSensingModel humanSensingModel );
	public List < HumanSensingModel > getAllHumanSensingData ();
}

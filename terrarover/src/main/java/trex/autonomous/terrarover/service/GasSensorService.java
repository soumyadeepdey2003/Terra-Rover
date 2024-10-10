package trex.autonomous.terrarover.service;

import trex.autonomous.terrarover.model.GasSensorModel;

import java.util.List;

/**
 * @author soumyadeep Dey
 * @created 26-08-2024 - 09:31 pm
 * @package-name trex.autonomous.terrarover.service
 * @project terrarover
 */

public interface GasSensorService {
	public GasSensorModel addGasSensorData ( GasSensorModel gasSensorModel );
	public List < GasSensorModel > getAllGasSensorData ();
}

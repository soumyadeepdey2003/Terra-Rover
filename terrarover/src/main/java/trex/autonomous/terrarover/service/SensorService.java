package trex.autonomous.terrarover.service;

import trex.autonomous.terrarover.model.SensorModel;

import java.util.List;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:19 pm
 * @package-name trex.autonomous.terrarover.service
 * @project terrarover
 */

public interface SensorService {
	public SensorModel addSensorData ( SensorModel sensorModel );
	public List < SensorModel > getAllSensorData ();
}

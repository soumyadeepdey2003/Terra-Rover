package trex.autonomous.terrarover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trex.autonomous.terrarover.model.SensorModel;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:17 pm
 * @package-name trex.autonomous.terrarover.repository
 * @project terrarover
 */

@Repository
public interface SensorRepository extends JpaRepository < SensorModel, Long > {
}

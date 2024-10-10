package trex.autonomous.terrarover.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:35 pm
 * @package-name trex.autonomous.terrarover.model
 * @project terrarover
 */

@Data
@Entity
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HumanSensingModel implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	private String latitude; // Latitude of the human sensor
	private String longitude; // Longitude of the human sensor

	private Boolean isHumanDetected; // Human detection sensor

	private Double heartRate; // Heart rate sensor
	private Double pulseRate; // Pulse rate sensor

}

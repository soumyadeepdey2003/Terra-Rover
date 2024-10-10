package trex.autonomous.terrarover.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:08 pm
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
public class SensorModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String latitude; // latitude sent by the GPS
	private String longitude; // longitude sent by the GPS

	private Boolean isFireDetected = false; // fire detected by the fire sensor
	private Boolean isCrackDetected = false; // crack detected by the crack sensor

	private Double temperature; // temperature sent by the temperature sensor
	private Double humidity; // humidity sent by the humidity sensor

}

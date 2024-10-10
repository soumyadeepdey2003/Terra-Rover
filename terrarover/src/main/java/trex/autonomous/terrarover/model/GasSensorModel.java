package trex.autonomous.terrarover.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

/**
 * @author Soumyadeep Dey
 * @created 26-08-2024 - 09:22 pm
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
public class GasSensorModel implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	private String latitude; // Latitude of the gas sensor
	private String longitude; // Longitude of the gas sensor

	private Double lpg; // LPG gas sensor
	private Double butane; // Butane gas sensor
	private Double methane; // Methane gas sensor
	private Double alcohol; // Alcohol gas sensor
	private Double carbonMonoxide; // Carbon Monoxide gas sensor
	private Double isoButane; // Iso-Butane gas sensor
	private Double ammonia; // Ammonia gas sensor
	private Double hydrogen; // Hydrogen gas sensor
	private Double smoke; // Smoke gas sensor
	private Double sulfide; // Sulfide gas sensor
	private Double c7h8; // C7H8 gas sensor
	private Double carbonDioxide; // Carbon Dioxide gas sensor

}

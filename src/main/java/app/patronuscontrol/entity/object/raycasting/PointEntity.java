package app.patronuscontrol.entity.object.raycasting;

import app.patronuscontrol.model.dto.PointDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PointEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;
	private double x;
	private double y;


	public PointEntity(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public PointDTO toDTO() {
		PointDTO pointDTO = new PointDTO();
		pointDTO.setId(this.id);
		pointDTO.setX(this.x);
		pointDTO.setY(this.y);
		return pointDTO;
	}

}

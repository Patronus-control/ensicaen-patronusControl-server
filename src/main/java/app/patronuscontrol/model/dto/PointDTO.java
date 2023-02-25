package app.patronuscontrol.model.dto;

import app.patronuscontrol.entity.object.raycasting.PointEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PointDTO {
    private Long id;

    private double x;
    private double y;



    PointEntity toEntity() {
        PointEntity pointEntity = new PointEntity();
        pointEntity.setId(this.id);
        pointEntity.setX(this.x);
        pointEntity.setY(this.y);
        return pointEntity;
    }


}

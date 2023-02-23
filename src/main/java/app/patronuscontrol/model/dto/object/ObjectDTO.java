package app.patronuscontrol.model.dto.object;

import app.patronuscontrol.entity.object.ObjectEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDTO {

    private Long id;

    private String idObjectType;


     public ObjectEntity toEntity() {
         return null;
     }

}

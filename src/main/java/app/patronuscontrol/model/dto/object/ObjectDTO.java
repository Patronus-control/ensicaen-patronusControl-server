package app.patronuscontrol.model.dto.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ObjectDTO {

    private Long id;

    private String idObjectType;


    public abstract Object toEntity();






}

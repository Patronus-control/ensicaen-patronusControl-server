package app.patronuscontrol.model.dto.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ObjectDTO {

    private Long id;

    private String idObjectType;

    private String name;

    public abstract Object toEntity();






}

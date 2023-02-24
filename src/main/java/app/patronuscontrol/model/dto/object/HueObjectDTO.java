package app.patronuscontrol.model.dto.object;

import app.patronuscontrol.entity.object.HueObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HueObjectDTO extends ObjectDTO {


    private int hueId;

    @Override
    public HueObject toEntity() {
        HueObject hueObject = new HueObject();
        hueObject.setId(this.getId());
        hueObject.setHueId(this.getHueId());
        return hueObject;
    }
}

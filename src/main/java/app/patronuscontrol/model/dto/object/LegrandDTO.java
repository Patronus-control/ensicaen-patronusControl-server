package app.patronuscontrol.model.dto.object;

import app.patronuscontrol.entity.object.LegrandObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegrandDTO extends ObjectDTO {

    private String ip;


    @Override
    public LegrandObject toEntity() {
        LegrandObject legrandObject = new LegrandObject();
        legrandObject.setId(this.getId());
        legrandObject.setIp(this.getIp());
        return legrandObject;
    }
}

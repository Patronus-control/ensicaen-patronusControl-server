package app.patronuscontrol.entity.object;

import app.patronuscontrol.model.dto.object.HueObjectDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HueObject extends ObjectEntity {
    private int hueId;


    public HueObjectDTO toDTO() {
        HueObjectDTO hueObjectDTO = new HueObjectDTO();
        hueObjectDTO.setId(this.getId());
        hueObjectDTO.setHueId(this.getHueId());
        return hueObjectDTO;
    }


}

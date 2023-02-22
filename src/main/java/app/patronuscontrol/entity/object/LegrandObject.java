package app.patronuscontrol.entity.object;

import app.patronuscontrol.model.dto.object.LegrandDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LegrandObject extends ObjectEntity {

    private String ip;


    @Override
    public LegrandDTO toDTO() {
        LegrandDTO legrandDTO = new LegrandDTO();
        legrandDTO.setId(this.getId());
        legrandDTO.setIp(this.getIp());
        return legrandDTO;
    }

    @Override
    public void fetchStateListAttributes() {
        return;
    }
}

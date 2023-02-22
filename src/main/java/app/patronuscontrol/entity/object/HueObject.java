package app.patronuscontrol.entity.object;

import app.patronuscontrol.configuration.AppConfig;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.model.contract.philips.HueLight;
import app.patronuscontrol.model.dto.object.HueObjectDTO;
import app.patronuscontrol.service.apiservice.PhilipsService;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

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

    public void fetchStateListAttributes() {
        if (this.getObjectTypeEntity() != null) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            PhilipsService philipsService = context.getBean(PhilipsService.class);
            HueLight hueLight;

            try {
                hueLight = philipsService.getLight(hueId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            this.getObjectTypeEntity().setObjectAttributeEntity(hueLight.getAttribute());
        }
    }


    public Map<Attribute, Object> getStateList() {
        this.fetchStateListAttributes();

        return super.getStateList();
    }

}

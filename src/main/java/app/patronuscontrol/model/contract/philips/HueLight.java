package app.patronuscontrol.model.contract.philips;

import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import app.patronuscontrol.entity.object.attribute.OnOffHue;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.webjars.NotFoundException;

public class HueLight extends ConcreteObject {

    public HueLight(JSONObject data) throws JSONException {
        ObjectAttributeEntity onOff = new OnOffHue();
        onOff.setState(data.getJSONObject("state").getBoolean("on"));
        this.attribute = onOff;
    }

    @Override
    public Object getState(Attribute att) {
        return this.getState(att, this.attribute);
    }

    public Object getState(Attribute att, ObjectAttributeEntity attEntity) {
        if(attEntity == null) {
           throw new NotFoundException("Attribute not found on the object");
        } else if(att == attEntity.getAttribute()) {
            return attEntity.getState();
        } else {
            return this.getState(att, attEntity.getObjectAttributeEntity());
        }
    }
}

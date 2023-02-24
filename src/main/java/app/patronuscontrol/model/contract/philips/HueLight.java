package app.patronuscontrol.model.contract.philips;

import app.patronuscontrol.entity.object.attribute.BrightnessHue;
import app.patronuscontrol.entity.object.attribute.ColorHue;
import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import app.patronuscontrol.entity.object.attribute.OnOffHue;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import lombok.Getter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.webjars.NotFoundException;

@Getter
public class HueLight extends ConcreteObject {
    int id;

    public HueLight(JSONObject data) throws JSONException {
        OnOffHue onOff = new OnOffHue();
        onOff.setState(data.getJSONObject("state").getBoolean("on"));

        BrightnessHue brightness = new BrightnessHue();
        brightness.setState(data.getJSONObject("state").getInt("bri"));
        onOff.setObjectAttributeEntity(brightness);

        if(data.getString("type").equals("Extended color light")) {
            ColorHue color = new ColorHue();
            brightness.setObjectAttributeEntity(color);
        }

        this.attribute = onOff;
        this.name = data.getString("name");
    }

    public HueLight(JSONObject data, int id) throws JSONException {
        this(data);
        this.id = id;
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

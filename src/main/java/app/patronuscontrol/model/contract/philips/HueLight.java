package app.patronuscontrol.model.contract.philips;

import lombok.Getter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Getter
public class HueLight extends HueObject{
    private boolean on;

    public HueLight(JSONObject data) throws JSONException {
        this.on = data.getJSONObject("state").getBoolean("on");
        this.name = data.getString("name");
    }
}

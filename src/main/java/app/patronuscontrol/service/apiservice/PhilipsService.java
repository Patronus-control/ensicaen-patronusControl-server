package app.patronuscontrol.service.apiservice;

import app.patronuscontrol.model.contract.philips.HueLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class PhilipsService extends BasicApiService{
    private final String authToken;

    @Autowired
    public PhilipsService(@Value("${philips.endpoint}") String endpoint, @Value("${philips.auth-token}") String authToken) {
        super(endpoint);
        this.authToken = authToken;
    }

    public List<HueLight> getAllLights() throws IOException, InterruptedException, JSONException {
        String result = this.sendHttpRequest("/api/" + authToken + "/lights", "GET");

        ArrayList<HueLight> ret = new ArrayList<>();

        JSONObject allData = new JSONObject(result);
        Iterator<String> i = allData.keys();

        while (i.hasNext()){
            String key = i.next();
            ret.add(new HueLight(allData.getJSONObject(key)));
        }

        return ret;
    }

    public HueLight getLight(int id) throws IOException, InterruptedException, JSONException {
        String result = this.sendHttpRequest("/api/" + authToken + "/lights/" + id, "GET");

        return new HueLight(new JSONObject(result));
    }

    public boolean isLightOn(int id) throws IOException, InterruptedException, JSONException {
        return this.getLight(id).isOn();
    }

    public void setLightOn(int id, boolean state) throws IOException, InterruptedException {
        Map<Object, Object> values = new HashMap<>();
        values.put("on", state);

        this.sendHttpRequest(values, this.endpoint + "/api/" + authToken + "/lights/" + id + "/state", "PUT");
    }
}

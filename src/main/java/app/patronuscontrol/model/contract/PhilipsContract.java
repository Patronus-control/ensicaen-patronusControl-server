package app.patronuscontrol.model.contract;

import app.patronuscontrol.model.contract.philips.HueLight;
import io.swagger.v3.core.util.Json;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhilipsContract extends BrandContract{
    private String authToken;


    public PhilipsContract(String endpoint, String authToken) {
        super(endpoint);
        this.authToken = authToken;
    }

    public PhilipsContract(String endpoint) {
        super(endpoint);
    }

    public List<HueLight> getAllLights() throws Exception {
        String result = this.sendRequest("/api/" + authToken + "/lights", "GET", null);

        ArrayList<HueLight> ret = new ArrayList<>();

        JSONObject allData = new JSONObject(result);
        Iterator<String> i = allData.keys();

        while (i.hasNext()){
            String key = i.next();
            ret.add(new HueLight(allData.getJSONObject(key)));
        }

        return ret;
    }

    public HueLight getLight(int id) throws Exception {
        String result = this.sendRequest("/api/" + authToken + "/lights/" + id, "GET", null);

        return new HueLight(new JSONObject(result));
    }

    public boolean isLightOn(int id) throws Exception {
        return this.getLight(id).isOn();
    }

    public void setLightOn(int id, boolean state) throws Exception {
        URL obj = new URL(this.endpoint + "/api/" + authToken + "/lights/" + id + "/" + state);
        HttpURLConnection httpCon = (HttpURLConnection) obj.openConnection();
        httpCon.setDoOutput(true);

        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write("{\"attribute\": \"ON_OFF\", \"state\": false}");
        osw.flush();
        osw.close();
        os.close();

        this.sendRequest("", "PUT", httpCon);
    }
}

package app.patronuscontrol.model.contract;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrandContract {
    protected String endpoint;

    public BrandContract(String endpoint) {
        this.endpoint = endpoint;
    }

    protected String sendRequest(String urlComplement, String requestMethod) throws Exception {
        URL obj = new URL(this.endpoint + urlComplement);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();

        return this.sendRequest(requestMethod, httpURLConnection);
    }

    protected String sendRequest(String requestMethod, HttpURLConnection httpURLConnection) throws Exception {
        httpURLConnection.setRequestMethod(requestMethod);
        int responseCode = httpURLConnection.getResponseCode();

        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();
        } else {
            throw new Exception("GET Failed");
        }

        System.out.println(response);

        return response.toString();
    }
}

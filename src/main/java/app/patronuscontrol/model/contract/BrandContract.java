package app.patronuscontrol.model.contract;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class BrandContract {
    protected String endpoint;

    public BrandContract(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendHttpRequest(String url, String method) throws IOException, InterruptedException {
        return this.sendHttpRequest(null, url, method);
    }

    public String sendHttpRequest(Map<Object, Object> values, String url, String method) throws IOException, InterruptedException {
        var objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(this.endpoint + url));

        if ("PUT".equalsIgnoreCase(method)) {
            if(values != null) {
                String requestBody = objectMapper.writeValueAsString(values);
                requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(requestBody));
            }
        } else if ("GET".equalsIgnoreCase(method)) {
            requestBuilder.GET();
        } // Add more HTTP methods as needed

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

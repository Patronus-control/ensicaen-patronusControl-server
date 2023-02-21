package app.patronuscontrol.service.apiservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public abstract class BasicApiService {

    protected String endpoint;

    @Autowired
    public BasicApiService() {

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
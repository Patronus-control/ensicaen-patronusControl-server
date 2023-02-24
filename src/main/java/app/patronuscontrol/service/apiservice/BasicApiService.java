package app.patronuscontrol.service.apiservice;

import app.patronuscontrol.repository.ObjectRepository;
import app.patronuscontrol.repository.ObjectTypeRepository;
import app.patronuscontrol.service.ObjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.time.Duration;

@Service
public class BasicApiService {

    private static final long TIMEOUT_SECONDS = 2;

    protected String endpoint;

    private PhilipsService philipsService;

    @Autowired
    public BasicApiService(PhilipsService philipsService) {
        this.philipsService = philipsService;
    }

    public BasicApiService() {

    }

    public void initialize(ObjectService objectService) {
        philipsService.initializeNetworkObjects(objectService);
    }

    public String sendHttpRequest(String url, String method) throws IOException, InterruptedException {
        return this.sendHttpRequest(null, url, method);
    }

    public String sendHttpRequest(Map<Object, Object> values, String url, String method) throws IOException, InterruptedException {
        var objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.endpoint + url))
                .timeout(Duration.ofSeconds(TIMEOUT_SECONDS));

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
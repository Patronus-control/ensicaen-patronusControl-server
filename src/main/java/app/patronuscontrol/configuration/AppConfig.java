package app.patronuscontrol.configuration;

import app.patronuscontrol.service.apiservice.PhilipsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public PhilipsService philipsService(@Value("${philips.endpoint}") String endpoint, @Value("${philips.auth-token}") String authToken) {
        return new PhilipsService(endpoint, authToken);
    }
}

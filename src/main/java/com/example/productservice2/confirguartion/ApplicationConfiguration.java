package com.example.productservice2.confirguartion;
import com.example.productservice2.services.FakeStoreProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

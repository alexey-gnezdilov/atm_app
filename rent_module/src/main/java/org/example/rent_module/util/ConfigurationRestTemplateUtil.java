package org.example.rent_module.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationRestTemplateUtil {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

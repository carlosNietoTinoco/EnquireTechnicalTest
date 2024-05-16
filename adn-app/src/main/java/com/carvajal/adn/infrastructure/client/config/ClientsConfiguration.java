package com.carvajal.adn.infrastructure.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
@Configuration
public class ClientsConfiguration {

    @Value("${AI_SERVER}")
    private String apiAi;
}

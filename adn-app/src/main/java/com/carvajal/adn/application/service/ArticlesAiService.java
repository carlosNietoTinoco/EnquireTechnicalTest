package com.carvajal.adn.application.service;

import com.carvajal.adn.infrastructure.client.config.ClientsConfiguration;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.carvajal.adn.application.client.AIClient;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticlesAiService {

    @Autowired
    ClientsConfiguration clientsConfiguration;

    @Autowired
    private final AIClient aiClient;

    public JsonObject search(String query) {
        log.info("Entra en el servicio");

        log.info("url api ai: " + clientsConfiguration.getApiAi());

        JsonObject response = aiClient.sendSearchRequest(query);

        log.info("Finaliza en el servicio");
        return response;
    }
}

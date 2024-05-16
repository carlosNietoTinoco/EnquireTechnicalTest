package com.carvajal.adn.infrastructure.client;

import com.carvajal.adn.application.client.AIClient;
import com.carvajal.adn.infrastructure.client.config.ClientsConfiguration;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

@Slf4j
@Component
public class AIClientImpl implements AIClient {

    private final ClientsConfiguration clientsConfiguration;
    private final HttpClient client;
    private final Gson gson;

    public AIClientImpl(ClientsConfiguration clientsConfiguration) {
        this.clientsConfiguration = clientsConfiguration;
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    @Override
    public JsonObject sendSearchRequest(String query) {

        try {
            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("query", query);

            log.info("datos url: " + "http://" + clientsConfiguration.getApiAi() + "/ask_pdf");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://" + clientsConfiguration.getApiAi() + "/ask_pdf"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: manejar mejor el error
            return new JsonObject();
        }
    }
}

package com.carvajal.adn.application.client;

import com.google.gson.JsonObject;

public interface AIClient {

    JsonObject sendSearchRequest(String query);
}

package com.carvajal.adn.infrastructure.rest;

import com.carvajal.adn.application.service.ArticlesAiService;
import com.carvajal.adn.infrastructure.rest.dto.AnswerDto;
import com.carvajal.adn.infrastructure.rest.dto.ResponseDto;
import com.carvajal.adn.infrastructure.rest.dto.SearchRequestDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/articles-ai")
@CrossOrigin("*")
@AllArgsConstructor
public class ArticlesAIController {

    @Autowired
    private ArticlesAiService articlesAIService;

    @PostMapping("/search")
    public ResponseEntity<AnswerDto> search(
            @RequestBody SearchRequestDto searchRequestDto) {
        log.info("Entra en el controlador");
        String query = searchRequestDto.getQuery();
        JsonObject jsonResponse = articlesAIService.search(query);
        AnswerDto answerDto = new Gson().fromJson(jsonResponse, AnswerDto.class);
        return ResponseEntity.ok(answerDto);
    }
    
}
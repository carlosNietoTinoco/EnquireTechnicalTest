package com.carvajal.adn.infrastructure.rest;

import com.carvajal.adn.application.service.ArticlesService;
import com.carvajal.adn.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
@CrossOrigin("*")
@AllArgsConstructor
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/test")
    public ResponseEntity<List<Article>> test() {

        List<Article> articles = articlesService.SearchArticles();
        return ResponseEntity.ok(articles);
    }
    
}
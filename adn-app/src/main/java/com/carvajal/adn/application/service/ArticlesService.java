package com.carvajal.adn.application.service;

import com.carvajal.adn.application.repository.ArticleRepository;
import com.carvajal.adn.domain.Article;
import com.carvajal.adn.domain.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticlesService {

    @Autowired
    private final ArticleRepository articleRepository;

    public List<Article> SearchArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(articleRepository.findById(123L));
        return articles;
    }
}

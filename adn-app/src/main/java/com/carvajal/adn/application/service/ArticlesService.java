package com.carvajal.adn.application.service;

import com.carvajal.adn.domain.Article;
import com.carvajal.adn.domain.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticlesService {

    public List<Article> SearchArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(createScopedArticle());
        return articles;
    }

    private Article createScopedArticle() {
        Source source = new Source();
        source.setId(123);
        source.setName("Example Source");

        Article article = Article.builder()
                .source(source)
                .author("John Doe")
                .title("Example Title")
                .description("Example Description")
                .url("https://example.com")
                .urlToImage("https://example.com/image.jpg")
                .publishedAt("2024-05-12T12:00:00Z")
                .content("Example Content")
                .build();

        return article;
    }
}

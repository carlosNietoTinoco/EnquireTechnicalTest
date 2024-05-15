package com.carvajal.adn.infrastructure.db.repository;

import com.carvajal.adn.application.repository.ArticleRepository;
import com.carvajal.adn.domain.Article;
import com.carvajal.adn.domain.Source;
import com.carvajal.adn.infrastructure.db.ArticleEntityMapper;
import com.carvajal.adn.infrastructure.db.repository.jpa.ArticleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {

    private final ArticleEntityMapper articleEntityMapper;
    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public Article findById(Long id) {
        return articleJpaRepository
                .findById(1L)
                .map(articleEntityMapper::toDomain)
                .orElse(null);
    }

    private Article createScopedArticle() {
        Source source = new Source();
        source.setId(1234);
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

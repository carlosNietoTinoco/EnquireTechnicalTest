package com.carvajal.adn.application.repository;

import com.carvajal.adn.domain.Article;

public interface ArticleRepository {
    Article findById(Long id);
}

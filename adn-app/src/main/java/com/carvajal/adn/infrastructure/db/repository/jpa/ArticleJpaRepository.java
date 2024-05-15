package com.carvajal.adn.infrastructure.db.repository.jpa;

import com.carvajal.adn.infrastructure.db.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
    @Override
    Optional<ArticleEntity> findById(Long id);
}

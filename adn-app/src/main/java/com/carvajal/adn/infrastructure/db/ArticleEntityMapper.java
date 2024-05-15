package com.carvajal.adn.infrastructure.db;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.carvajal.adn.domain.Article;
import com.carvajal.adn.infrastructure.db.model.ArticleEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleEntityMapper {

    @Mapping(target = "sourceId", source = "source.id")
    @Mapping(target = "sourceName", source = "source.name")
    ArticleEntity toEntity(Article article);

    @Mapping(target = "source.id", source = "sourceId")
    @Mapping(target = "source.name", source = "sourceName")
    Article toDomain(ArticleEntity articleEntity);

    List<ArticleEntity> toEntityList(List<Article> articles);

    List<Article> toDomainList(List<ArticleEntity> articleEntities);
}

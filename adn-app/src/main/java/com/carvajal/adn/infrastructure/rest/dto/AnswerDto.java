package com.carvajal.adn.infrastructure.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerDto {

    private String answer;
    private List<SourceDto> sources;

}

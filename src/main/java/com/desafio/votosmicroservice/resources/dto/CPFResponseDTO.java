package com.desafio.votosmicroservice.resources.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPFResponseDTO {
    private String message;
}

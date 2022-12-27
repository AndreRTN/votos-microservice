package com.desafio.votosmicroservice.resources.controllers;


import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.desafio.votosmicroservice.resources.dto.CPFResponseDTO;
import com.desafio.votosmicroservice.resources.dto.ErrorResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("users")
@Slf4j
public class CPFController {

    @GetMapping("{cpf}")
    public Mono<ResponseEntity<Object>> checkValidCpf(@PathVariable String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        String formatCpf = cpf.replaceAll("\\.", "").replaceAll("-", "");
        List<ValidationMessage> errors = cpfValidator.invalidMessagesFor(formatCpf);
            if(!errors.isEmpty()) {
                errors.forEach(err -> log.error(err.getMessage()));
                ErrorResultDTO errorResultDTO = ErrorResultDTO.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message("CPF Inválido")
                        .build();
                return Mono.just(new ResponseEntity<>(errorResultDTO, HttpStatus.NOT_FOUND));
            }

            CPFResponseDTO cpfResponseDTO = CPFResponseDTO.builder().message("ABLE_TO_VOTE").build();
            return Mono.just(new ResponseEntity<>(cpfResponseDTO, HttpStatus.ACCEPTED));

        }

}

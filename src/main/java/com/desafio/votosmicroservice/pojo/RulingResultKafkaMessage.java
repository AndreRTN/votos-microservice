package com.desafio.votosmicroservice.pojo;


import lombok.Data;
import lombok.ToString;

@Data
public class RulingResultKafkaMessage {
    private Long total;
    private String name;
    private Long id;
    private Long positiveVote;
    private Long negativeVote;
}

package com.desafio.votosmicroservice.pojo;


import com.desafio.votosmicroservice.types.VoteResultType;
import lombok.Data;
import lombok.ToString;

@Data
public class RulingResultKafkaMessage {
    private Long total;
    private String name;
    private Long id;
    private Long positiveVote;
    private Long negativeVote;
    private VoteResultType result;
}

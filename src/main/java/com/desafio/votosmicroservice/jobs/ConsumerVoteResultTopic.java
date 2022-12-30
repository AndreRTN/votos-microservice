package com.desafio.votosmicroservice.jobs;


import com.desafio.votosmicroservice.constants.Topics;
import com.desafio.votosmicroservice.pojo.RulingResultKafkaMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ConsumerVoteResultTopic {


    private final ObjectMapper mapper;

    @Autowired
    public ConsumerVoteResultTopic(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = Topics.VOTE_RESULT_TOPIC, groupId = "group_id")
    public void consume(String voteResult) throws IOException {
        RulingResultKafkaMessage kafkaMessage = mapper.readValue(voteResult, RulingResultKafkaMessage.class);
        log.info("### Vote Result -> : " + kafkaMessage);
    }
}

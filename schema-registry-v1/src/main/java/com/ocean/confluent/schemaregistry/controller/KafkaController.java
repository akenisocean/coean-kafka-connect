package com.ocean.confluent.schemaregistry.controller;

import com.ocean.confluent.schemaregistry.models.User;
import com.ocean.confluent.schemaregistry.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chao
 * @description
 * @create 2021-03-15 20:02
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
    }

    @PostMapping("/jsonPush")
    public void jsonPush(@RequestBody String pushJson){
       kafkaProducer.sendJsonMessage(pushJson);
    }
}

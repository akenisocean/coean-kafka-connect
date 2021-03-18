package com.ocean.confluent.schemaregistry.producer;

import com.ocean.confluent.schemaregistry.avro.dto.UserDto;
import com.ocean.confluent.schemaregistry.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.PrimitiveIterator;

/**
 * @author chao
 * @description
 * @create 2021-03-15 20:00
 */
@Service
@Slf4j
public class KafkaProducer {
    private static final String TOPIC = "users";

    @Resource
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    @Resource
    KafkaTemplate<String,String> stringKafkaTemplate;

    public void sendMessage(User user) {
        UserDto userDto = UserDto.newBuilder().setAge(user.getAge())
                .setName(user.getName())
                .build();
        log.info(String.format("#### -> Producing message -> %s", userDto));
        this.kafkaTemplate.send(TOPIC, userDto);
    }


    public void sendJsonMessage(String jsonStr) {
        log.info(String.format("#### -> Producing message -> %s", jsonStr));
        stringKafkaTemplate.send(TOPIC, jsonStr);
    }


}

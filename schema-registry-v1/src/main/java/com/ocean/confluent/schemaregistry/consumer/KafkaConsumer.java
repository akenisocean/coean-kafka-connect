package com.ocean.confluent.schemaregistry.consumer;

import com.ocean.confluent.schemaregistry.avro.dto.UserDto;
import com.ocean.confluent.schemaregistry.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author chao
 * @description
 * @create 2021-03-15 20:02
 */
@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(@Payload UserDto userDto, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) throws IOException {
        log.info(String.format("#### -> partiton->%s, Consumed message -> %s", partition,userDto));
    }
}

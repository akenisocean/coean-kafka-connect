package com.ocean.confluent.schemaregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SchemaRegistryV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SchemaRegistryV1Application.class, args);
	}

}

package com.ocean.confluent.schemaregistry.models;

import lombok.*;

/**
 * @author chao
 * @description
 * @create 2021-03-15 19:56
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;

}

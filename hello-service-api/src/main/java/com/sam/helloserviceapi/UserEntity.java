package com.sam.helloserviceapi;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by sam on 17-11-29.
 */
@Data
@AllArgsConstructor
public class UserEntity {
    private String name;
    private Integer age;
}

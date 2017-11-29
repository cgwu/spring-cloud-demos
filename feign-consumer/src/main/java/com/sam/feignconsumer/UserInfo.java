package com.sam.feignconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by sam on 17-11-29.
 */
@Data
@AllArgsConstructor
public class UserInfo {
    private String name;
    private Integer age;
}

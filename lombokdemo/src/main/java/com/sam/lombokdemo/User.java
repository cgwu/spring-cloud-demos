package com.sam.lombokdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sam on 17-11-28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;

    public User(String name){
        this(name,-1);
    }

}

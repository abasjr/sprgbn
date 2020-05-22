package com.abasjr.abasweb.model;

import org.springframework.stereotype.Component;

// 11 Component Injection
@Component  // kalau di non-aktifkan maka constructor in com.abasjr.abasweb.model.SayHello required a bean of type 'com.abasjr.abasweb.model.SayHelloFilter' that could not be found.
public class SayHelloFilter {
   
    public String filter(String value){
        return value.toUpperCase();
    }
}
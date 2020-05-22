package com.abasjr.abasweb.model;

import org.springframework.stereotype.Component;

// 10 Component
// Component Scan, ketika ditambahkan maka spring configuration nya mampu menscanning semua class2 yang ada di dalam packagenya
// Dimana ketika menemukan sebuah class (lalu di tag @Component), maka secara otomatis akan dibuatkan 1 buah Bean berdasarkan class tersebut

@Component // kalau tidak dibuat muncul "No qualifying bean of type 'com.abasjr.abasweb.model.SayHello' available"
public class SayHello {
    
    public String hello(String name){
        return "Hello " + name;
    }
}
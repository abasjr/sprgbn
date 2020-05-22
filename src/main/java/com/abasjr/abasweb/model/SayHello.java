package com.abasjr.abasweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 10 Component
// Component Scan, ketika ditambahkan maka spring configuration nya mampu menscanning semua class2 yang ada di dalam packagenya
// Dimana ketika menemukan sebuah class (lalu di tag @Component), maka secara otomatis akan dibuatkan 1 buah Bean berdasarkan class tersebut

@Component // kalau tidak dibuat muncul "No qualifying bean of type 'com.abasjr.abasweb.model.SayHello' available"
public class SayHello {

    // 11 Component Injection
    private SayHelloFilter nama;

    @Autowired // Kalau ini di non aktifkan maka Hello Anggit tidak akan keluar
    // Jika ingin melakukan dependency injection entah di Contructors, Field, Method. Parameter
    public SayHello(SayHelloFilter nama) {
        this.nama= nama;
    }
    

    // 10 Component
    public String hello(String name){
        // 11 Component Injection
        return nama.filter("Hello " + name);
    }
}
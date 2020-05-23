package com.abasjr.abasweb.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

// 13 Lifecycle
// beberapa bean ada yang membutuhkan alur lifecycle, ketika start melakukan apa, ketika stop melakukan apa?

@Component
public class DatabaseService {

    // Method ini perlu dipanggil saat pertama kali spring membuat object database service, caranya dengan @PostConstruct
    @PostConstruct //spring otomatis panggil method openCOnnection ketika DatabaseService selesai dibuat
    public void openConnection(){
        System.out.println("---------MEMBUKA KONEKSI KE DATABASE");
    }

    @PreDestroy // method ini dipanggil ketika Bean di destroy
    public void lostConnection(){
        System.out.println("---------MENUTUP KONEKSI KE DATABASE");
    }
}
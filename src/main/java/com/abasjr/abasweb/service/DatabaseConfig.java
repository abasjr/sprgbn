package com.abasjr.abasweb.service;

// 15 Profile
// Dengan menambahkan @Profile pada Bean atau Component maka si Sping akan membuat Bean berdasarkan profile yang kita tentukan
// Kalau profile nya sama maka akan dibuat, kalau profilenya berbeda maka tidak akan dibuat 
public class DatabaseConfig {
    
    private String value;

    public DatabaseConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
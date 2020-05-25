package com.abasjr.abasweb.service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.abasjr.abasweb.model.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// 21 Bean Validation (Automatic, Step 2) 
@Component
@Validated // untuk memberitahu Spring bahwa disini perlu dilakukan validasi
// @Validated akan mencari method mana yang ada Tag Validationnya
public class UserService {

    public void save(@Valid User user){
        System.out.println("Sukses menyimpan User baru.");
    }

    // Cara kedua, bisa juga langusng di methodnya
    public User getById(@NotBlank String id){
        System.out.println("Sukses mengambil data User.");
        return null;
    }
}
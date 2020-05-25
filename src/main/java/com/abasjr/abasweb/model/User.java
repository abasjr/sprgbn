package com.abasjr.abasweb.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

// 21 Bean Validator
public class User {

    @NotBlank(message = "Tidak boleh kosong!")
    @Length(min = 5)
    private String id;

    @NotBlank
    private String username;
    
    @NotBlank
    @Email
    private String email;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
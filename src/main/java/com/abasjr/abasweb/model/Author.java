package com.abasjr.abasweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 19 Property Source, step 3 (habis hapus file di configuration)
@Component

// 19 Property Source
public class Author {

    private String name;
    private String email;

    // public Author(String name, String email) {
    //     this.name = name;
    //     this.email = email;
    // }

    // step 3 rubah ke component
    @Autowired
    public Author(@Value("${author.name}") String name, @Value("${author.email}") String email) {
        this.name = name;
        this.email = email;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
package com.abasjr.abasweb.validation;

import com.abasjr.abasweb.model.Author;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// 20 Spring Validation
// Spring memiliki mekanisme untuk melakukan validasi
// implement sebuah interface bernama Validator

public class AuthorValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.isAssignableFrom(clazz); //ini gunakan agar tidak hanya class Author saja validasinya, tetapi jg class turunan Author
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author author = (Author) target;

        if (author.getName() == null || author.getName().trim().isEmpty()) {
            errors.rejectValue("name", "author.name.blank");
        }         
        if (author.getEmail() == null || author.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "author.email.blank");
        } 

    }
    
}
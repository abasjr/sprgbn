package com.abasjr.abasweb.model;

// 17 Internationalization
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class SayMorning implements MessageSourceAware{

    private MessageSource messageSource;

    public String morning(String name){
        // CARA 1
        // return (messageSource.getMessage("morning", null, Locale.getDefault()) + " " + name);

        // CARA 2, pakai parameter yg ditambahin di morning.properties
        return (messageSource.getMessage("morning", new Object[]{name}, Locale.getDefault()));
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
}
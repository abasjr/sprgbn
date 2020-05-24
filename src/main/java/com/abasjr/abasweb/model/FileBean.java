package com.abasjr.abasweb.model;

import java.io.IOException;
import java.util.Scanner;


import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

// 18 Resource Loader
@Component
public class FileBean implements ResourceLoaderAware {

    private ResourceLoader loader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void printInfo() throws IOException{
        // bisa classpath: , file: , http:
        org.springframework.core.io.Resource resource = loader.getResource("classpath:/sources/info.txt");
        Scanner input = new Scanner(resource.getInputStream());
        while(input.hasNextLine()){
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }
}
package com.denisabramov.postings;

import com.denisabramov.postings.service.PostingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;


@SpringBootApplication
public class PostingsApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ConfigurableApplicationContext context = SpringApplication.run(PostingsApplication.class, args);
        var service = context.getBean(PostingService.class);
        service.init();
    }

}

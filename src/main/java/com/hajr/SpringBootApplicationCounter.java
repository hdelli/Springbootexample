package com.hajr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication


public class SpringBootApplicationCounter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);

    }

    static int count= 0;

    @GetMapping(path= "current-count")
    int currentCount(){
        return count;
    }


    @GetMapping("increment-count")
    int incrementCount(){
        count++;
        return count;

    }

    @GetMapping("decrement-count")
    int decrementCount(){
        count--;
        return count;
    }


}


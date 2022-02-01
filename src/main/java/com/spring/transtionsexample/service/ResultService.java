package com.spring.transtionsexample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResultService {

    public String fetchResult(){
        int number=randomNumber();
        log.info("number is {}",number);
        if(number%3==0){
            return "DONE";
        }else if(number%2==0){
            return "Open";
        }else{
            return "ERROR";
        }
    }

    private int randomNumber(){
        double random = Math.random();
       double d= random * 100;
       return (int) d;
    }
}

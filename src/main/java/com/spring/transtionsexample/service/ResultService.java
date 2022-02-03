package com.spring.transtionsexample.service;

import com.spring.transtionsexample.util.ProcessingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResultService {

    public ProcessingStatus fetchResult(){
        int number=randomNumber();
        log.info("number is {}",number);
        if(number%7==0){
            return ProcessingStatus.ERROR;
        }else if(number%11==0){
            return ProcessingStatus.DONE;
        }else{
            return ProcessingStatus.ONGOING;
        }
    }

    private int randomNumber(){
        double random = Math.random();
       double d= random * 100;
       return (int) d;
    }
}

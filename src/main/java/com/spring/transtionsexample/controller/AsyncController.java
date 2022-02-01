package com.spring.transtionsexample.controller;

import com.spring.transtionsexample.entity.AsyncEntity;
import com.spring.transtionsexample.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/rest")
public class AsyncController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/post")
    public void postJob(AsyncEntity asyncEntity){
        asyncEntity.setStatus("OPEN");
        asyncEntity.setAttempt(0);
        asyncEntity.setCreationDate(LocalDateTime.now());
        asyncEntity.setModificationDate(LocalDateTime.now());
        taskRepository.save(asyncEntity);
    }
}

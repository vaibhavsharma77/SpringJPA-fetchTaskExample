package com.spring.transtionsexample.controller;

import com.spring.transtionsexample.entity.AsyncEntity;
import com.spring.transtionsexample.repository.TaskRepository;
import com.spring.transtionsexample.util.AsyncTaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/rest")
public class AsyncController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/post")
    public void postJob(AsyncEntity asyncEntity){

        asyncEntity.setStatus(AsyncTaskStatus.OPEN);
        asyncEntity.setAttempt(0);
        asyncEntity.setCaseId(UUID.randomUUID().toString());
        asyncEntity.setCreationDate(LocalDateTime.now());
        asyncEntity.setModificationDate(LocalDateTime.now());
        taskRepository.save(asyncEntity);
    }

}

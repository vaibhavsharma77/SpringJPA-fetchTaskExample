package com.spring.transtionsexample;

import com.spring.transtionsexample.entity.AsyncEntity;
import com.spring.transtionsexample.repository.TaskRepository;
import com.spring.transtionsexample.util.AsyncTaskStatus;
import com.spring.transtionsexample.util.ProcessingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Slf4j
public class AsyncTaskDao {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public AsyncEntity fetchTask(){
        log.info("AsyncTaskDao::fetchTask inside fetch task method");
        Optional<AsyncEntity> open = taskRepository.findByStatusAndAttemptLessThanAndModificationDateLessThan(AsyncTaskStatus.OPEN,3, LocalDateTime.now().minusSeconds(10));
        if (open.isPresent()){
            updateTaskAfterFetch(open.get());
            return open.get();
        }else{
           log.info("No Open record present to process....");
        }
        return null;
    }

    private void updateTaskAfterFetch(AsyncEntity asyncEntity){
        log.info("fetchTask::updateTaskAfterFetch inside fetch method");
        asyncEntity.setStatus(AsyncTaskStatus.FETCH);
        asyncEntity.setAttempt(asyncEntity.getAttempt()+1);
        taskRepository.save(asyncEntity);
    }

    @Transactional
    public void updateStatus(AsyncTaskStatus status, AsyncEntity asyncEntity){
        log.info("fetchTask::updateStatus to update the status");
        asyncEntity.setStatus(status);
        asyncEntity.setAttempt(asyncEntity.getAttempt());
        taskRepository.save(asyncEntity);
    }


}

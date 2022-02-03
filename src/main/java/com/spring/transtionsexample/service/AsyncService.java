package com.spring.transtionsexample.service;

import com.spring.transtionsexample.AsyncTaskDao;
import com.spring.transtionsexample.entity.AsyncEntity;
import com.spring.transtionsexample.util.AsyncTaskStatus;
import com.spring.transtionsexample.util.ProcessingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncService {

    @Autowired
    private AsyncTaskDao taskDao;

    @Autowired
    private ResultService resultService;


    public void processing() {
        log.info("AsyncService::processing entry point");
        AsyncEntity asyncEntity;
        while ((asyncEntity = taskDao.fetchTask()) != null) {
            log.info("AsyncService::processing get the record from task dao to process further...");
            ProcessingStatus result = resultService.fetchResult();
            if (result.equals(ProcessingStatus.ONGOING)) {
                taskDao.updateStatus(AsyncTaskStatus.OPEN, asyncEntity);
                if(asyncEntity.getAttempt()==3){
                    log.info("Maximum attempts are successfully used {} ",asyncEntity.getAttempt());
                }
            } else if (result.equals(ProcessingStatus.DONE)) {
                taskDao.updateStatus(AsyncTaskStatus.DONE, asyncEntity);
            } else {
                taskDao.updateStatus(AsyncTaskStatus.ERROR, asyncEntity);
            }
        }

        log.info("AsyncService::processing exit point");
    }


}

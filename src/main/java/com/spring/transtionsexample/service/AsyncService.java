package com.spring.transtionsexample.service;

import com.spring.transtionsexample.AsyncTaskDao;
import com.spring.transtionsexample.entity.AsyncEntity;
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
            String result = resultService.fetchResult();
            if (result.equalsIgnoreCase("Ongoing")) {
                taskDao.updateStatus("OPEN", asyncEntity);
            } else if (result.equalsIgnoreCase("done")) {
                taskDao.updateStatus("DONE", asyncEntity);
            } else {
                taskDao.updateStatus("ERROR", asyncEntity);
            }
        }
        log.info("AsyncService::processing exit point");
    }


}

package com.spring.transtionsexample.repository;

import com.spring.transtionsexample.entity.AsyncEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<AsyncEntity,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<AsyncEntity> findByStatusAndAttemptLessThanAndModificationDateLessThan(String status, int attempt, LocalDateTime localDateTime);
}
